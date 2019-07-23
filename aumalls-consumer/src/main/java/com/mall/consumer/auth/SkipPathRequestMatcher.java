package com.mall.consumer.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private Logger logger = LoggerFactory.getLogger(SkipPathRequestMatcher.class);

    public SkipPathRequestMatcher(List<String> anonUrl){
        List<RequestMatcher> requestMatchers = anonUrl.stream()
                .map(AntPathRequestMatcher::new)
                .collect(Collectors.toList());

        anonMatcher = new OrRequestMatcher(requestMatchers);

        logger.debug("anon-matcher:" + anonMatcher.toString());
    }

    @Override
    public boolean matches(HttpServletRequest request) {
        logger.debug("request-uri:" + request.getRequestURI() + "result:" + anonMatcher.matches(request));
        return !anonMatcher.matches(request);
    }
}
