package com.mall.consumer.auth;

import com.mall.common.utils.GsonUtils;
import com.mall.common.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Egan
 * @date 2019/7/21 15:34
 **/
@Component
public class AuthHandler implements
    AuthenticationEntryPoint, AuthenticationSuccessHandler, AccessDeniedHandler, LogoutSuccessHandler {
    private final static Logger logger = LoggerFactory.getLogger(AuthHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("login success");
        httpServletResponse.getWriter().write(GsonUtils.get().toJson(R.ok()));
    }

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("not login");
        //跳转至登录界面
        httpServletResponse.sendRedirect("/login");
    }

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        logger.info("without permission");
        httpServletResponse.getWriter().write(GsonUtils.get().toJson(R.error(403, "无权限")));
    }


    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("logout success");
        httpServletResponse.getWriter().write(GsonUtils.get().toJson(R.ok()));
    }
}
