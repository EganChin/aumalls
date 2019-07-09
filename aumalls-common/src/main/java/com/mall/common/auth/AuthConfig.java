package com.mall.common.auth;

import com.mall.common.config.annotation.SecurityConfig;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import com.mall.common.config.annotation.*;

import java.time.Duration;


/**
 * @author LiangYongjie
 * @date 2019-01-15
 */
@SecurityConfig
@Configuration
@ConfigurationProperties("security")
public class AuthConfig {

    private Duration timeout = Duration.ofMinutes(15);

    private String salt;

    public Duration getTimeout() {
        return timeout;
    }

    public String getSalt() {
        return salt;
    }

    public void setTimeout(Duration timeout) {
        this.timeout = timeout;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }
}
