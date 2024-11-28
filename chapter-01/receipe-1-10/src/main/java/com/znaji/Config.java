package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public Product cdrw() {
        return ProductCreator.createProduct("cdrw");
    }

    @Bean
    public Product dvdrw() {
        return ProductCreator.createProduct("dvdrw");
    }

    @Bean
    public Product aaa() {
        return ProductCreator.createProduct("aaa");
    }

    @Bean
    public Product aa() {
        return ProductCreator.createProduct("aa");
    }
}
