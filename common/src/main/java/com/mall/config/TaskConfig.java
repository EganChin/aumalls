package com.mall.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

/**
 * @author LiangYongjie
 * @date 2019-05-29
 */
@Configuration
@ConfigurationProperties("task")
public class TaskConfig {

    private Duration claimTimeout;
    private Duration statusTimeout;
    private Integer maxRunning = 5;

    public long getClaimTimeout() {
        return claimTimeout.toMillis();
    }

    public void setClaimTimeout(Duration claimTimeout) {
        this.claimTimeout = claimTimeout;
    }

    public long getStatusTimeout() {
        return statusTimeout.toMillis();
    }

    public void setStatusTimeout(Duration statusTimeout) {
        this.statusTimeout = statusTimeout;
    }

    public long getSum() {
        return getClaimTimeout() + getStatusTimeout();
    }

    public Integer getMaxRunning() {
        return maxRunning;
    }

    public void setMaxRunning(Integer maxRunning) {
        this.maxRunning = maxRunning;
    }
}
