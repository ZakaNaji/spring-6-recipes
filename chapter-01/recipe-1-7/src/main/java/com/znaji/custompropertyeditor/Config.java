package com.znaji.custompropertyeditor;

import com.znaji.Disc;
import com.znaji.Product;
import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public static CustomEditorConfigurer customEditorConfigurer() {
        CustomEditorConfigurer configurer = new CustomEditorConfigurer();
        configurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{
                registry -> registry.registerCustomEditor(Disc.class, new CustomPropertyEditor())
        });
        return configurer;
    }

    @Bean
    public ProductService productService(@Value("dvds,20.0,700") Disc disc) {
        return new ProductService(disc);
    }

}
