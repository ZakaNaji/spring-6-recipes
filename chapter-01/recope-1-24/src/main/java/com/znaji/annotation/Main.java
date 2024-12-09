package com.znaji.annotation;

import com.znaji.Product;
import com.znaji.ShoppingCart;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(Config.class);

        var cart1 = context.getBean("cart", ShoppingCart.class);
        var cdrw = context.getBean("cdrw", Product.class);
        var dvdrw = context.getBean("dvdrw", Product.class);
        var aaa = context.getBean("aaa", Product.class);
        cart1.addItem(cdrw);
        cart1.addItem(dvdrw);
        cart1.addItem(aaa);

        var cashier = context.getBean(Cashier.class);
        cashier.checkout(cart1);

        var cart2 = context.getBean("cart", ShoppingCart.class);
        cart2.addItem(cdrw);
        cart2.addItem(aaa);
        cashier.checkout(cart2);

    }
}
