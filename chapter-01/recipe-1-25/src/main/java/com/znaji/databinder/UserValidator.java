package com.znaji.databinder;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if (user.getName() == null || user.getName().isEmpty()) {
            errors.rejectValue("name", "name.empty");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            errors.rejectValue("email", "email.empty");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            errors.rejectValue("password", "password.empty");
        }
        if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
            errors.rejectValue("confirmPassword", "confirmPassword.empty");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.invalid");
        }
        if (user.getCountry() == null || user.getCountry().isEmpty()) {
            errors.rejectValue("country", "country.empty");
        }
        if (user.getPhone() == null || user.getPhone().isEmpty()) {
            errors.rejectValue("phone", "phone.empty");
        }
    }
}
