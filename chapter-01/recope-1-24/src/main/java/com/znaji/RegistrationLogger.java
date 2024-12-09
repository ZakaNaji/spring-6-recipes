package com.znaji;

import org.springframework.context.ApplicationListener;

public class RegistrationLogger implements ApplicationListener<UserRegistrationEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        System.out.println("User registered with username: " + event.getUsername() + " and email: " + event.getEmail());
    }
}
