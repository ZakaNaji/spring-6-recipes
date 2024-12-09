package com.znaji.annotation;

import com.znaji.Battery;
import com.znaji.Disc;
import com.znaji.Product;
import com.znaji.ShoppingCart;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    public CheckoutListener checkoutListener() {
        return new CheckoutListener();
    }

    @Bean
    public Cashier cashier(ApplicationEventPublisher publisher) {
        return new Cashier(publisher);
    }

    @Bean
    public Product cdrw() {
        return new Disc("CD-RW", 1.0, 700);
    }

    @Bean
    public Product dvdrw() {
        return new Disc("DVD-RW", 2.5, 700);
    }

    @Bean
    public Product aaa() {
        return new Battery("AAA", 2.5, true);
    }

    @Bean
    @Scope("prototype")
    public ShoppingCart cart() {
        return new ShoppingCart();
    }
}
