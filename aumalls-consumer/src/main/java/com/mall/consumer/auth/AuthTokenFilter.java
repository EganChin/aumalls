package com.mall.consumer.auth;

import com.google.gson.GsonBuilder;
import com.mall.common.domain.Operator;
import com.mall.common.exception.NRException;
import com.mall.common.exception.RRException;
import com.mall.common.utils.R;
import org.apache.zookeeper.Op;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.util.StringUtils;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author egan
 * @date 2019/7/22 10:39
 * @desc 认证拦截器
 */
public class AuthTokenFilter extends AbstractAuthenticationProcessingFilter {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);

    private static final String TOKEN = "token";


    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    protected AuthTokenFilter(RequestMatcher requiresAuthenticationRequestMatcher) {
        super(requiresAuthenticationRequestMatcher);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws AuthenticationException, IOException, ServletException {
        String token = this.getToken(httpServletRequest, httpServletResponse);

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null && auth.isAuthenticated()){
            return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials());
        }

        Operator operator = (Operator) redisTemplate.opsForValue().get(token);

        if(operator == null){
            write(httpServletResponse, R.error(HttpStatus.UNAUTHORIZED.value(), "令牌过期或不存在"));
            throw new RRException( "令牌过期或不存在", HttpStatus.UNAUTHORIZED.value());
        }


        return new UsernamePasswordAuthenticationToken(token, operator, new ArrayList<>());

    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContext context = SecurityContextHolder.createEmptyContext();
        context.setAuthentication(authResult);
        SecurityContextHolder.setContext(context);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        SecurityContextHolder.clearContext();

        logger.debug("用户登录失败", failed);

        write(response, R.error(HttpStatus.UNAUTHORIZED.value(), "登录失败"));
    }

    public String getToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String token = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(token))
            token = request.getParameter(TOKEN);
        if(StringUtils.isEmpty(token)){
            for(Cookie cookie : request.getCookies())
                if(cookie.getName().equals(TOKEN)){
                    token = cookie.getValue();
                    break;
                }
        }
        if (StringUtils.isEmpty(token)){
            write(response, R.error(HttpStatus.UNAUTHORIZED.value(), "令牌无效"));
            throw new NRException("令牌无效");
        }
        return token;
    }

    private void write(HttpServletResponse response, R result) throws IOException {
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(new GsonBuilder()
                .serializeNulls()
//                .registerTypeAdapter(Json.class, new SpringfoxJsonToGsonSeializer())
                .create().toJson(result));
    }
}
