package com.znaji.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class PersonValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty");

        Person person = (Person) target;
        if (person.getAge() < 0) {
            errors.rejectValue("age", "negative.value");
        } else if (person.getAge() > 110) {
            errors.rejectValue("age", "too.darn.old", new Object[]{person.getAge()}, "You are too old!");
        }
    }
}
