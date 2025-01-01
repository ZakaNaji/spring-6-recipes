package com.znaji.recipe1.config;

import com.znaji.service.ReservationService;
import com.znaji.service.impl.InMemoryReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan(basePackages = "com.znaji.recipe1")
@EnableWebMvc
public class CourtWebConfig {

    @Bean
    InternalResourceViewResolver internalResourceViewResolver() {
        var viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Bean
    public ReservationService reservationService() {
        return new InMemoryReservationService();
    }
}
