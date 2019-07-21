package com.mall.consumer.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Egan
 * @date 2019/7/21 22:56
 **/
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {


//    @Autowired
//    AjaxAuthenticationEntryPoint authenticationEntryPoint;//未登陆时返回 JSON 格式的数据给前端（否则为 html）
//
//    @Autowired
//    AjaxAuthenticationSuccessHandler authenticationSuccessHandler; //登录成功返回的 JSON 格式数据给前端（否则为 html）
//
//    @Autowired
//    AjaxAuthenticationFailureHandler authenticationFailureHandler; //登录失败返回的 JSON 格式数据给前端（否则为 html）
//
//    @Autowired
//    AjaxLogoutSuccessHandler logoutSuccessHandler;//注销成功返回的 JSON 格式数据给前端（否则为 登录时的 html）
//
//    @Autowired
//    AjaxAccessDeniedHandler accessDeniedHandler;//无权访问返回的 JSON 格式数据给前端（否则为 403 html 页面）
//
//    @Autowired
//    SelfUserDetailsService userDetailsService; // 自定义user
//
//    @Autowired
//    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter; // JWT 拦截器

    @Autowired
    AuthHandler authHandler;

    @Autowired
    UserDetailService userDetailsService;

    @Autowired
    private AuthFilter authFilter;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 加入自定义的安全认证
//        auth.authenticationProvider(provider);
        auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // 去掉 CSRF
        http.csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 使用 JWT，关闭token
            .and()

            .httpBasic().authenticationEntryPoint(authHandler)

            .and()
            .authorizeRequests()//定义哪些URL需要被保护、哪些不需要被保护

            .anyRequest()//任何请求,登录后可以访问
            .access("@rbacauthorityservice.hasPermission(request,authentication)") // RBAC 动态 url 认证

            .and()
            .formLogin()  //开启登录, 定义当需要用户登录时候，转到的登录页面
//                .loginPage("/test/login.html")
//                .loginProcessingUrl("/login")
            .successHandler(authHandler) // 登录成功
            .permitAll()

            .and()
            .logout()//默认注销行为为logout
            .logoutUrl("/logout")
            .logoutSuccessHandler(authHandler)
            .permitAll();

        // 记住我
        http.rememberMe().rememberMeParameter("remember-me")
            .userDetailsService(userDetailsService).tokenValiditySeconds(1000);

        http.exceptionHandling().accessDeniedHandler(authHandler); // 无权访问 JSON 格式的数据
        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
