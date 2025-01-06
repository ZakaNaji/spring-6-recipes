package com.znaji.generalConfig;

import com.znaji.recipe1.config.FileDownloadHandler;
import com.znaji.recipe1.config.TestController;
import com.znaji.recipe1.controller.WelcomeController;
import com.znaji.recipe3.Recipe3Config;
import com.znaji.recipe4.Recipe4Config;
import com.znaji.recipe5.Recipe5Config;
import com.znaji.recipe7.Recipe7Config;
import com.znaji.service.ReservationService;
import com.znaji.service.impl.InMemoryReservationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.mvc.Controller;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.time.Duration;
import java.util.Map;
import java.util.Properties;

@Configuration
@Import({Recipe3Config.class, Recipe4Config.class, Recipe5Config.class, Recipe7Config.class})
@ComponentScan(basePackages = "com.znaji")
@EnableWebMvc
public class CourtWebConfig {

    @Bean
    public ReservationService reservationService() {
        return new InMemoryReservationService();
    }

    @Bean
    public BeanNameUrlHandlerMapping beanNameUrlHandlerMapping() {
        return new BeanNameUrlHandlerMapping();
    }

    @Bean("/test")
    public Controller testController() {
        return new TestController();
    }

    @Bean("/file")
    public HttpRequestHandler fileDownload() {
        return new FileDownloadHandler();
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver cookieLocaleResolver = new CookieLocaleResolver("locale");
        cookieLocaleResolver.setCookieMaxAge(Duration.ofHours(1));
        return cookieLocaleResolver;
    }

}
