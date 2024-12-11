package com.znaji.custompropertyeditor;

import com.znaji.Disc;
import com.znaji.Product;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;

import java.util.Set;

@Configuration
public class Config {

    @Bean
    public StringToDiscConverted stringToDiscConverted() {
        return new StringToDiscConverted();
    }

    @Bean
    public ConversionService conversionService() {
        ConversionServiceFactoryBean factory = new ConversionServiceFactoryBean();
        factory.setConverters(Set.of(stringToDiscConverted()));
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public ProductService productService(@Value("dvds,20.0,700") Disc disc) {
        return new ProductService(disc);
    }

}
