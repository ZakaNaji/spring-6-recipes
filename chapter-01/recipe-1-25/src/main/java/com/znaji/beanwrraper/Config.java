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
    public FormattingConversionService conversionService(FormattingConversionServiceFactoryBean factoryBean) {
        return factoryBean.getObject();
    }

    @Bean
    public FormattingConversionServiceFactoryBean conversionServiceFactoryBean() {
        FormattingConversionServiceFactoryBean factoryBean = new FormattingConversionServiceFactoryBean();
        factoryBean.setFormatters(Set.of(new EmployeeFormatter(" - ")));
        factoryBean.setFormatterRegistrars(Set.of(registry ->
                registry.addFormatterForFieldAnnotation(new EmployeeFormatAnnotaionFactory())));
        return factoryBean;
    }

    @Bean
    EmployeeFormatterExample employeeFormatterExample() {
        return new EmployeeFormatterExample();
    }

}
