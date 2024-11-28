package com.znaji;

import org.springframework.beans.factory.config.BeanPostProcessor;

public class ProductCheckBeanPostProcessor implements BeanPostProcessor {

    public ProductCheckBeanPostProcessor() {
        super();
        System.out.println("ProductCheckBeanPostProcessor constructor, will be created early in the application context");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) {
        System.out.println("BeforeInitialization : " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) {
        System.out.println("AfterInitialization : " + beanName);
        return bean;
    }

}
