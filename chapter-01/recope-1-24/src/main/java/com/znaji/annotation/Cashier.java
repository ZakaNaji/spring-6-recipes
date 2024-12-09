package com.znaji.annotation;

import com.znaji.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;

import java.time.LocalDateTime;

public class Cashier {

    private ApplicationEventPublisher publisher;

    @Autowired
    public Cashier(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    public void checkout(ShoppingCart cart) {
        this.publisher.publishEvent(new CheckoutEvent(cart, LocalDateTime.now()));
    }
}
