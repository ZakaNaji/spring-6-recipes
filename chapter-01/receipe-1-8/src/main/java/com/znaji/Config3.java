package com.znaji;

import org.springframework.context.annotation.Bean;

public class Config3 {

    @Bean
    public Cashier cashier() {
        var path = "checkout1";
        return new Cashier("checkout", path);
    }
}
