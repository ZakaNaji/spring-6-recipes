package com.znaji.validation;

import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

public class NestedObjectValidationApp {
    public static void main(String[] args) {
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
                System.out.println(error.getCode());
            });
        }
    }
}
