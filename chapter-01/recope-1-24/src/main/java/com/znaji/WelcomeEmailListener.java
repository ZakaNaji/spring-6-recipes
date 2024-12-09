package com.znaji;

import org.springframework.context.ApplicationListener;

public class WelcomeEmailListener implements ApplicationListener<UserRegistrationEvent> {
    @Override
    public void onApplicationEvent(UserRegistrationEvent event) {
        System.out.println("Welcome email sent to: " + event.getEmail());
    }
}
