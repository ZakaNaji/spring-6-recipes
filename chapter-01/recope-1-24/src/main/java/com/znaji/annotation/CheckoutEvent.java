package com.znaji.annotation;

import com.znaji.ShoppingCart;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CheckoutEvent {
    private final ShoppingCart cart;
    private final LocalDateTime time;

    public CheckoutEvent(ShoppingCart cart, LocalDateTime time) {
        this.cart = cart;
        this.time = time;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "CheckoutEvent{" +
                "cart=" + cart +
                ", time=" + time.format(DateTimeFormatter.ISO_LOCAL_DATE) +
                '}';
    }
}
