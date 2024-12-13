package com.znaji.validation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Locale;

public class NestedObjectValidationApp {
    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(Config.class);

        // Create a new customer
        Customer customer = new Customer();
        customer.setName("John Doe");
        customer.setEmail("");
        customer.setAddress(new Address("", ""));

        AddressValidator addressValidator = new AddressValidator();
        CustomerValidator customerValidator = new CustomerValidator(addressValidator);
        Errors errors = new BeanPropertyBindingResult(customer, "customer");

        customerValidator.validate(customer, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                var message = ctx.getMessage(error, Locale.US);
                System.out.println(message);
            });
        }
    }
}
