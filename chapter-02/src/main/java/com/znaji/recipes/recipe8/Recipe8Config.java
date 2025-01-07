package com.znaji.recipes.recipe8;

import com.znaji.exception.ReservationNotFoundException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

import java.util.List;
import java.util.Properties;

@Configuration
public class Recipe8Config implements WebMvcConfigurer {

    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add(courtHandlerExceptionResolver());
    }

    @Bean
    public HandlerExceptionResolver courtHandlerExceptionResolver() {
        Properties exceptionMapping = new Properties();
        exceptionMapping.put(ReservationNotFoundException.class.getName(), "reservationNotFound");

        SimpleMappingExceptionResolver mappingExceptionResolver = new SimpleMappingExceptionResolver();
        mappingExceptionResolver.setExceptionMappings(exceptionMapping);
        mappingExceptionResolver.setDefaultErrorView("error");
        return mappingExceptionResolver;
    }
}
