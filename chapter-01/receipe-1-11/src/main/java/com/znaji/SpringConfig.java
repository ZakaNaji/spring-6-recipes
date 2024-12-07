package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("spring")
public class SpringConfig {

    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.5, true);
    }
    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.5, 700);
    }
    @Bean
    public Product dvdrw() {
        return new Disc("DVD-RW", 3.0, 4700);
    }
}
