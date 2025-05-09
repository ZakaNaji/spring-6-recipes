package com.znaji;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

@Configuration
public class MessageSourceConfig {

    @Bean
    public MessageSource messageSource() {
       var messageSource = new ReloadableResourceBundleMessageSource();
         messageSource.setBasename("classpath:alert");
         messageSource.setCacheSeconds(1);
         return messageSource;
    }
}
