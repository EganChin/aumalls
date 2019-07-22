package com.mall.consumer.auth;

import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.AnyRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotEmpty;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author egan
 * @date 2019/7/22 14:10
 * @desc
 */
public class SkipPathRequestMatcher implements RequestMatcher {

    private OrRequestMatcher anonMatcher;

    public SkipPathRequestMatcher(List<String> anonUrl){
        List<RequestMatcher> requestMatchers = anonUrl.stream()
                .map(AntPathRequestMatcher::new)
                .collect(Collectors.toList());

        anonMatcher = new OrRequestMatcher(requestMatchers);
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        return !anonMatcher.matches(request);
    }
}
