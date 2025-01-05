package com.znaji.recipe3;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class Recipe3Config implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(timeMeasurementInterceptor());
    }

    @Bean
    public HandlerInterceptor timeMeasurementInterceptor() {
        return new TimeMeasurementInterceptor();
    }
}
