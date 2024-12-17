package com.znaji.beanwrraper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.support.FormattingConversionService;

import java.util.Date;

public class DataFormatterExample {

    @Value("2019-01-01")
    private Date date;

    public void displayDate() {
        System.out.println("Date: " + date);
    }

}
