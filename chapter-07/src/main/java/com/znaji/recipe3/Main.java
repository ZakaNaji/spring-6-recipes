package com.znaji.recipe3;

import com.znaji.service.BookShop;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        ProductService productService = ctx.getBean(ProductService.class);

        productService.addTenProducts();
    }
}
