package com.znaji.javabeanvalidation;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
@Validated
public class OrderService {

    public void placeOrder(@Valid PersonForm personForm) {
        System.out.println("Order placed for " + personForm.getName());
    }
}
