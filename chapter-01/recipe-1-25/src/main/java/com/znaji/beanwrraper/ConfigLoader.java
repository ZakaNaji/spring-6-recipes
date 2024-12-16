package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Map;

public class ConfigLoader {

    public void loadProperties(Object bean, Map<String, Object> properties) {
        BeanWrapper beanWrapper = new BeanWrapperImpl(bean);
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            beanWrapper.setPropertyValue(entry.getKey(), entry.getValue());
        }
    }
}
