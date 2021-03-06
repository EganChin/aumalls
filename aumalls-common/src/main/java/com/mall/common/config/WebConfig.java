package com.mall.common.config;

import com.mall.common.utils.GsonUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.GsonHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * @author LiangYongjie
 * @date 2019-01-07
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.removeIf(httpMessageConverter -> httpMessageConverter instanceof MappingJackson2HttpMessageConverter);
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(GsonUtils.get());
        converters.add(converter);
    }

    @Bean
    public RequestContextListener requestContextListener(){
        return new RequestContextListener();
    }

//    @Override
//    protected void addFormatters(FormatterRegistry registry) {
//        registry.addConverterFactory(new EnumConverterFactory());
//    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("classpath:/META-INF/resources/WEB-INF/resources");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/META-INF/resources/WEB-INF/resources/images/");
//        registry.addResourceHandler("/swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        super.addResourceHandlers(registry);
    }
}
