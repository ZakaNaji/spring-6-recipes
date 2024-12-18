package com.znaji.beanwrraper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeFormatterExample {

    @Value("John Doe - 100000.0")
    private Employee employee;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Value("2019-01-01")
    private String date;

    public void displayEmployee() {
        System.out.println("Employee: " + employee);
    }

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var app = ctx.getBean(EmployeeFormatterExample.class);
        app.displayEmployee();
        System.out.println("Date: " + app.date);
    }
}
