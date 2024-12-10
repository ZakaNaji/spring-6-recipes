package com.znaji.propertysource;

import com.znaji.Disc;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@PropertySource("classpath:discounts.properties")
public class PropertySourceConfig {

    @Value("${endofyear.discount:0}")
    private double discount;

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public Disc dvd() {
        Disc dvd = new Disc("DVD", 100, 4);
        dvd.applyDiscount(discount);
        return dvd;
    }
}
