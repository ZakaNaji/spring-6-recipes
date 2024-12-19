package com.znaji.databinder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Map;

public class DataBinderApp {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        var userService = ctx.getBean(UserService.class);
        userService.save(Map.of(
            "name", "",
            "email", "znaji@gmail.com",
            "password", "22222",
            "confirmPassword", "123456",
            "country", "Morocco",
            "phone", "123456789"
        ));
    }
}
