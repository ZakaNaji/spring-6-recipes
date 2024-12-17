package com.znaji.beanwrraper;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

public class EmployeeFormatter implements Formatter<Employee> {
    @Override
    public Employee parse(String text, Locale locale) throws ParseException {
        String[] data = text.split(",");
        Employee employee = new Employee();
        employee.setName(data[0]);
        employee.setSalary(Double.parseDouble(data[1]));
        return employee;
    }

    @Override
    public String print(Employee object, Locale locale) {
        return object.getName() + "," + object.getSalary();
    }
}
