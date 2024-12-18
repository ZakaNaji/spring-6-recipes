package com.znaji.javabeanvalidation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UppercaseValidator.class)
public @interface Uppercase {
    String message() default "Value must be uppercase";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
