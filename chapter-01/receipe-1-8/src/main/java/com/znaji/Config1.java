package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

@Configuration
@Import(Config3.class)
public class Config1 {

    @Bean
    public Disc dvd() {
        return new Disc("DVD", 10.0, 700);
    }

    @Bean
    public Disc cd() {
        return new Disc("CD", 5.0, 700);
    }

    @Bean
    public Battery aaa() {
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    public Battery aa() {
        return new Battery("AA", 3.5, true);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
