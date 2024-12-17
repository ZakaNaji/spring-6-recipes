package com.znaji.beanwrraper;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

import java.util.Collections;
import java.util.Set;

@Configuration
@PropertySource("classpath:company.properties")
public class Config {

    @Bean
    public FormattingConversionService conversionService() {
        FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();
        //factoryBean.setFormatters(Set.of(new EmployeeFormatter(" - ")));
        factoryBean.setFormatterRegistrars(Set.of(registry ->
                registry.addFormatterForFieldAnnotation(new EmployeeFormatAnnotaionFactory())));
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }

    @Bean
    EmployeeFormatterExample employeeFormatterExample() {
        return new EmployeeFormatterExample();
    }

}
