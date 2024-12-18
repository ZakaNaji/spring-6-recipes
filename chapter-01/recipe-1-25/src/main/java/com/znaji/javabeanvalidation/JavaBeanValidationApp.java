package com.znaji.javabeanvalidation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaBeanValidationApp {
    public static void main(String[] args) {
        System.out.println("Java Bean Validation App");

        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var registrationService = ctx.getBean(RegistrationService.class);
        registrationService.register(new PersonForm("JOHN DOE", 25));
    }
}
