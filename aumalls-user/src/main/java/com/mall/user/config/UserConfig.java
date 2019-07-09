package com.mall.user.config;

import com.mall.user.impl.Provider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Egan
 * @date 2019/7/9 14:45
 **/
@Configuration
public class UserConfig {

    @Bean
    public Provider getProvider(){
        return new Provider();
    }

}
