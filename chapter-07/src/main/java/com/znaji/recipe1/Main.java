package com.znaji.recipe1;

import com.znaji.service.BookShop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        BookShop bookShop = ctx.getBean(BookShop.class);
        bookShop.purchase("ISBN004", "charlie");
    }
}
