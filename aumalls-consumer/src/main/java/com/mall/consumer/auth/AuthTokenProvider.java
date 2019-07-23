package com.mall.consumer.auth;

import com.google.gson.GsonBuilder;
import com.mall.common.exception.RRException;
import com.mall.common.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author egan
 * @date 2019/7/22 11:26
 * @desc 安全校验器
 */
public class AuthTokenProvider implements AuthenticationProvider {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if(auth != null && auth.isAuthenticated()){
            return new UsernamePasswordAuthenticationToken(auth.getPrincipal(), null);
        }

        String token = (String) authentication.getPrincipal();

        if(token == null)
            throw new RRException("Invalid Token",HttpStatus.UNAUTHORIZED.value());

        UserDetails userDetails = (UserDetails) redisTemplate.opsForValue().get(token);

        if(userDetails == null)
            throw new RRException( "令牌过期d或不存在", HttpStatus.UNAUTHORIZED.value());


        return new UsernamePasswordAuthenticationToken(token, null, new ArrayList<>());

    }

    @Override
    public boolean supports(Class<?> aClass) {


        return aClass.equals(UsernamePasswordAuthenticationToken.class);
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
