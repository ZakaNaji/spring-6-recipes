package com.znaji.javabeanvalidation;

import com.znaji.javabeanvalidation.PersonForm;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;


@Service
public class RegistrationService {

    private final Validator validator;

    @Autowired
    public RegistrationService(Validator validator) {
        this.validator = validator;
    }

    public void register(PersonForm personForm) {
        Set<ConstraintViolation<PersonForm>> personConstraints = validator.validate(personForm);
        if (!personConstraints.isEmpty()) {
            for (ConstraintViolation<PersonForm> constraintViolation : personConstraints) {
                System.out.println(constraintViolation.getMessage());
            }
            throw new IllegalArgumentException(personConstraints.iterator().next().getMessage());
        }

        System.out.println("Person registered successfully, with name: " + personForm.getName() + " and age: " + personForm.getAge());
    }
}
