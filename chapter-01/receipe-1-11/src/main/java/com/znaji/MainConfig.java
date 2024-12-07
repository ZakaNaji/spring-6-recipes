package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SpringConfig.class, AutumnConfig.class, WinterAndSummerConfig.class})
public class MainConfig {

    @Bean
    public Cashier cashier() {
        var path = System.getProperty("java.io.tmpdir") + "/cashier";
        return new Cashier("checkout", path);
    }
}
