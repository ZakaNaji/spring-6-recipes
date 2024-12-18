package com.znaji.javabeanvalidation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MethodValidationApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var orderService = ctx.getBean(OrderService.class);
        var personForm = new PersonForm("John Doe", 225);
        try {
            orderService.placeOrder(personForm);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
