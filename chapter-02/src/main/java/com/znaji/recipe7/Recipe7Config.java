package com.znaji.recipe7;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Recipe7Config implements WebMvcConfigurer {

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorParameter(true)
                .parameterName("type")
                .mediaType("txt", MediaType.TEXT_PLAIN)
                .mediaType("html", MediaType.TEXT_HTML);
    }

    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.enableContentNegotiation();
        registry.jsp("/WEB-INF/jsp/", ".jsp");
        registry.viewResolver(plainTextViewResolver());
    }

    @Bean
    public ViewResolver plainTextViewResolver() {
        return new PlainTextViewResolver();
    }
}
