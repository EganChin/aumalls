package com.mall.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Egan
 * @date 2019/7/8 15:21
 **/
@EnableCaching
@EnableScheduling
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ImportResource({"classpath:provider.xml"})
@ComponentScan(basePackages = "com.mall.user")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
