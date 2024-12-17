package com.znaji.beanwrraper;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DateFormatterApp {

    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var app = ctx.getBean(DataFormatterExample.class);
        app.displayDate();
    }
}
