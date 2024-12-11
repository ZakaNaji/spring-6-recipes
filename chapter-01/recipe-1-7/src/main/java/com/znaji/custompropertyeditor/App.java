package com.znaji.custompropertyeditor;

import com.znaji.Disc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        var productService = ctx.getBean(ProductService.class);
        productService.displayProduct();
    }
}
