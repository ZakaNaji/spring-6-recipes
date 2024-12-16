package com.znaji.beanwrraper;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import java.util.Map;

public class BeanWrapperApp {

    public static void main(String[] args) {
        ConfigLoader configLoader = new ConfigLoader();
        Employee employee = new Employee();
        configLoader.loadProperties(employee, Map.of("name", "John Doe", "salary", 10_000.0));
        System.out.println(employee);

        Company company = new Company();
        configLoader.loadProperties(company, Map.of("name", "ACME", "managingDirector", employee));
        System.out.println(company);

    }
}
