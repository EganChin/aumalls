package com.mall.common.auth;

import com.google.gson.Gson;
import com.mall.common.config.annotation.SecurityConfig;
import com.mall.common.utils.R;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.AuthenticatingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * shiro 过滤器
 *
 * @author LiangYongjie
 * @date 2019-01-06
 */
@SecurityConfig
public class AuthFilter extends AuthenticatingFilter {

    private static final Logger log = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        String token = getRequestToken((HttpServletRequest) request);

        if (StringUtils.isBlank(token)) {
            return null;
        }

        return new AuthToken(token);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        String token = getRequestToken((HttpServletRequest) request);

        if (StringUtils.isBlank(token)) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            response.setContentType("application/json;charset=utf-8");
            String json = new Gson().toJson(R.error(401, "invalid token"));
            Writer writer = httpResponse.getWriter();
            writer.write(json);

            writer.close();
            return false;
        }

        return executeLogin(request, response);
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e,
                                     ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        response.setContentType("application/json;charset=utf-8");
        try {
            log.info("login failure:"+token);;
            String redirect = httpRequest.getRequestURI();
            if(redirect.contains("/manager"))
                redirect += "&admin=true";
            httpResponse.sendRedirect("/login?redirect=" + redirect);
            return false;
        } catch (IOException e1) {
            log.info("user failure");
        }

        return true;
    }

    /**
     * 获取请求中的token
     */
    private String getRequestToken(HttpServletRequest request) {
        return Arrays.stream(request.getCookies())
            .collect(Collectors.toMap(Cookie::getName, Cookie::getValue))
            .get("token");
    }
}
