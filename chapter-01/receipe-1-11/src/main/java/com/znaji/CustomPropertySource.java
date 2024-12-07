package com.znaji;

import org.springframework.core.env.PropertySource;

public class CustomPropertySource extends PropertySource<Object> {
    public CustomPropertySource() {
        super("customPropertySource");
    }

    @Override
    public Object getProperty(String name) {
        if ("spring.profiles.active".equals(name)) {
            return "autumn";
        }
        return null;
    }
}
