package com.znaji.beanwrraper;

import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

import java.lang.annotation.Annotation;
import java.util.Set;

public class EmployeeFormatAnnotaionFactory implements AnnotationFormatterFactory<EmployeeFormat> {
    @Override
    public Set<Class<?>> getFieldTypes() {
        return Set.of(Employee.class);
    }

    @Override
    public Printer<?> getPrinter(EmployeeFormat annotation, Class<?> fieldType) {
        return new EmployeeFormatter(annotation.pattern());
    }

    @Override
    public Parser<?> getParser(EmployeeFormat annotation, Class<?> fieldType) {
        return new EmployeeFormatter(annotation.pattern());
    }


}
