package com.mall.chat;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import com.mall.chat.server.WebSocketServer;
import com.mall.common.config.annotation.SecurityConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author Egan
 * @date 2019/7/8 15:21
 **/
@EnableScheduling
@EnableDubboConfiguration
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = "com.mall",
    excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION, value = SecurityConfig.class)})
@MapperScan(basePackages = "com.mall.chat.dao")
public class Application {


    private static WebSocketServer webSocketServer;

    @Autowired
    public Application(WebSocketServer webSocketServer) {
        Application.webSocketServer = webSocketServer;
    }


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        webSocketServer.start();
    }
}

