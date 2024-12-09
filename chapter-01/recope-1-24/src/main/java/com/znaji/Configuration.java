package com.znaji;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public UserRegistrationService userRegistrationService() {
        return new UserRegistrationService();
    }

    @Bean
    public RegistrationLogger registrationLogger() {
        return new RegistrationLogger();
    }

    @Bean
    public WelcomeEmailListener welcomeEmailListener() {
        return new WelcomeEmailListener();
    }


}
