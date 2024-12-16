package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class GenericBeanBuilder<T> {

    public T build(Class<T> clazz) {
        try {
            Map<String, String> properties = loadProperties(clazz.getSimpleName().toLowerCase());
            var obj = clazz.getDeclaredConstructor().newInstance();
            var beanWrapper = new BeanWrapperImpl(obj);

            for (var entry : properties.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                ensureNestedProperties(beanWrapper, key);
                beanWrapper.setPropertyValue(key, value);
            }
            return obj;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void ensureNestedProperties(BeanWrapper wrapper, String propertyPath) {
        String[] pathParts = propertyPath.split("\\.");
        StringBuilder currentPath = new StringBuilder();

        for (int i = 0; i < pathParts.length - 1; i++) {
            currentPath.append(pathParts[i]);
            if (wrapper.getPropertyValue(currentPath.toString()) == null) {
                Class<?> nestedType = wrapper.getPropertyType(currentPath.toString());
                try {
                    Object nestedInstance = nestedType.getDeclaredConstructor().newInstance();
                    wrapper.setPropertyValue(currentPath.toString(), nestedInstance);
                } catch (Exception e) {
                    throw new RuntimeException("Failed to instantiate nested property: " + currentPath, e);
                }
            }
            currentPath.append(".");
        }
    }

    private Map<String, String> loadProperties(String typeName) throws IOException {
        Properties properties = new Properties();
        properties.load(new ClassPathResource(typeName + ".properties").getInputStream());
        Map<String, String> map = new HashMap<>();

        for (var key : properties.stringPropertyNames()) {
            map.put(key, properties.getProperty(key));
        }
        return map;
    }
}
