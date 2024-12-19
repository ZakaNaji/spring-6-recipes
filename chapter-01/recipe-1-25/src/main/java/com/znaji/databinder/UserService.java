package com.znaji.databinder;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.stereotype.Service;
import org.springframework.validation.DataBinder;

import java.util.Map;

@Service
public class UserService {

    private final UserValidator userValidator;

    public UserService(UserValidator userValidator) {
        this.userValidator = userValidator;
    }

    public void save(Map<String, String> userMap) {
        User user = new User();
        DataBinder userBinder = new DataBinder(user);
        userBinder.setValidator(userValidator);
        userBinder.bind(new MutablePropertyValues(userMap));
        userBinder.validate();
        if (userBinder.getBindingResult().hasErrors()) {
            System.out.println("User not saved: " + userBinder.getBindingResult().getAllErrors());
            return;
        }
        System.out.println("User saved: " + user);
    }
}
