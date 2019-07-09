package com.mall.consumer.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author LiangYongjie
 * @date 2019-05-23
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Value("${swagger}")
    private boolean enable;

    @Bean
    public Docket createRestApi() {
        ParameterBuilder pb = new ParameterBuilder()
            .name("token")
            .modelRef(new ModelRef("string"))
            .parameterType("header")
            .required(false);
        List<Parameter> list = new ArrayList<>();
        list.add(pb.build());

        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(apiInfo())
            .enable(enable)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.golddak"))
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(list);
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
            .title("澳猫团API文档")
            .version("2.0")
            .build();
    }
}
