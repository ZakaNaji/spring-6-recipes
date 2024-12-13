package com.znaji.validation;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.Locale;

public class ValidationApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        Person person = new Person("Zakari", 130);
        PersonValidator validator = new PersonValidator();
        Errors errors = new BeanPropertyBindingResult(person, "person");

        validator.validate(person, errors);

        if (errors.hasErrors()) {
            errors.getAllErrors().forEach(error -> {
                var message = ctx.getMessage(error, Locale.US);
                System.out.println(message);
            });
        }
    }
}
