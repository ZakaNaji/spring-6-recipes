package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

public class BeanWrapperApp {

    public static void main(String[] args) {
        Company company = new Company();
        BeanWrapper companyWrapper = new BeanWrapperImpl(company);
        companyWrapper.setPropertyValue("name", "Some Company Inc.");
        companyWrapper.setPropertyValue("managingDirector", new Employee());
        companyWrapper.setPropertyValue("managingDirector.name", "John Doe");
        companyWrapper.setPropertyValue("managingDirector.salary", 100000.0);

        System.out.println(company);
    }
}
