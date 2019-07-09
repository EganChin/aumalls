package com.mall.common.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.mall.common.config.annotation.DatabaseConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author LiangYongjie
 * @date 2019-01-07
 */
@DatabaseConfig
@Configuration
public class MybatisConfig {

    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
