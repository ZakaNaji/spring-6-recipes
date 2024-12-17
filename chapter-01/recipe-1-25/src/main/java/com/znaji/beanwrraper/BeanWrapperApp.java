package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Date;
import java.util.Map;

public class BeanWrapperApp {

    public static void main(String[] args) {
        BeanWrapper companyWrapper = new BeanWrapperImpl(new Company());
        companyWrapper.registerCustomEditor(Date.class, new DateEditor());
        companyWrapper.setPropertyValue("name", "Some Company Inc.");
        //date format is yyyy-MM-dd
        companyWrapper.setPropertyValue("dateCreated", "1999-12-31");
        companyWrapper.setPropertyValue("managingDirector", new Employee());
        companyWrapper.setPropertyValue("managingDirector.name", "John Doe");
        companyWrapper.setPropertyValue("managingDirector.salary", 100000.0);
        System.out.println(companyWrapper.getWrappedInstance());
    }
}
