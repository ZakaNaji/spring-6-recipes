package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
public class Config1 {

    @Bean
    public ProductInstanceFactory productInstanceFactory() {
        return new ProductInstanceFactory(Map.of(
            "cdrw", new Disc("CD-RW", 1.0, 700),
            "dvdrw", new Disc("DVD-RW", 1.5, 4000),
            "aaa", new Battery("AAA", 2.5, true),
            "aa", new Battery("AA", 3.5, false)
        ));
    }

    @Bean
    public Product cdrw(ProductInstanceFactory productInstanceFactory) {
        return productInstanceFactory.createProduct("cdrw");
    }

    @Bean
    public Product dvdrw(ProductInstanceFactory productInstanceFactory) {
        return productInstanceFactory.createProduct("dvdrw");
    }

    @Bean
    public Product aaa(ProductInstanceFactory productInstanceFactory) {
        return productInstanceFactory.createProduct("aaa");
    }

    @Bean
    public Product aa(ProductInstanceFactory productInstanceFactory) {
        return productInstanceFactory.createProduct("aa");
    }
}
