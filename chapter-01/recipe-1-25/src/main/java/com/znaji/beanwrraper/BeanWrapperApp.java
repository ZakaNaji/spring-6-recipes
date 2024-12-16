package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Map;

public class BeanWrapperApp {

    public static void main(String[] args) {
        BeanWrapper exoticTypeWrapper = new BeanWrapperImpl(new ExoticType());
        exoticTypeWrapper.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());
        exoticTypeWrapper.setPropertyValue("name", "exotic");

        System.out.println(exoticTypeWrapper.getWrappedInstance());

    }
}
