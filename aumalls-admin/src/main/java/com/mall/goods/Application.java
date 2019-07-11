package com.mall.goods;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.mall.common.config.annotation.DatabaseConfig;
import com.mall.common.config.annotation.SecurityConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Egan
 * @date 2019/7/8 15:21
 **/
@EnableCaching
@EnableScheduling
@EnableDubboConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.mall.goods", "com.mall.common.config"},
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = SecurityConfig.class)})
@MapperScan(basePackages = "com.mall.goods.dao")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

