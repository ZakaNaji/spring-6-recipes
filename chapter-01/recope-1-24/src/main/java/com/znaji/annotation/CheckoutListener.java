package com.znaji.annotation;

import org.springframework.context.event.EventListener;

public class CheckoutListener {

    @EventListener
    public void onCheckoutEvent(CheckoutEvent event) {
        System.out.println("Checkout event: " + event);
    }
}
