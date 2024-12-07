package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile({"winter", "summer"})
public class WinterAndSummerConfig {

    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.0, true);
    }
    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.0, 700);
    }
    @Bean
    public Product dvdrw() {
        return new Disc("DVD-RW", 2.5, 4700);
    }
}
