package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Locale;

public class MessageSourceApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(MessageSourceConfig.class);
        var message = ctx.getMessage("alert.message", null, Locale.US);
        System.out.println(message);
    }
}
