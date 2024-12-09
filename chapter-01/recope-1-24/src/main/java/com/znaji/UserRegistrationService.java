package com.znaji;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class UserRegistrationService implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher applicationEventPublisher;

    public void registerUser(String username, String email) {
        // register user
        System.out.println("UserRegistrationService: registering user with username: " + username + " and email: " + email);
        // publish event
        applicationEventPublisher.publishEvent(new UserRegistrationEvent(this, username, email));
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }
}
