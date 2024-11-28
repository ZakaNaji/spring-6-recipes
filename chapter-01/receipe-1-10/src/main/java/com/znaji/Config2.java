package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config2 {

    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 250.5, 700);
    }

    @Bean
    public DiscountFactoryBean discountedCdrw(Product cdrw) {
        var factoryBean = new DiscountFactoryBean();
        factoryBean.setProduct(cdrw);
        factoryBean.setDiscount(0.25);
        return factoryBean;
    }
}
