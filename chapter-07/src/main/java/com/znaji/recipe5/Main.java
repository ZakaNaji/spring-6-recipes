package com.znaji.recipe5;

import com.znaji.service.BookShop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        try (var ctx = new AnnotationConfigApplicationContext(Config.class)) {
            BookShop bookShop = ctx.getBean(BookShop.class);

            bookShop.purchase("ISBN004", "admin");
        }
    }
}
