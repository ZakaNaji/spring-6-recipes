package com.znaji;

import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
@ComponentScan("com.znaji")
public class Config {

    @Bean
    public static CustomAutowireConfigurer customAutowireConfigurer() {
        var customAutowireConfigurer = new CustomAutowireConfigurer();
        customAutowireConfigurer.setCustomQualifierTypes(Set.of(CustomQualifier.class));
        return customAutowireConfigurer;
    }

    @Bean
    public ProductDoaImpl productDoa() {
        return new ProductDoaImpl("Hello from productDoa 0");
    }

    @Bean
    @CustomQualifier("pd1")
    public ProductDoaImpl anotherProductDoa() {
        return new ProductDoaImpl("Hello from anotherProductDoa 1");
    }

    @Bean
    @CustomQualifier("pd2")
    public ProductDoaImpl anotherProductDoa1() {
        return new ProductDoaImpl("Hello from anotherProductDoa 2");
    }

    @Bean
    @CustomQualifier("productDoa2")
    public Disc disc() {
        return new Disc("CD-RW", 1.0, 700);
    }

}
