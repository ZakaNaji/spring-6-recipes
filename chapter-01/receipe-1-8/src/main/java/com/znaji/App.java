package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        final Battery aa = context.getBean("aa", Battery.class);
        final Battery aaa = context.getBean("aaa", Battery.class);

        final Disc cd = context.getBean("cd", Disc.class);
        final Disc dvd = context.getBean("dvd", Disc.class);

        final ShoppingCart cart = context.getBean("cart", ShoppingCart.class);
        cart.addItem(aa);
        cart.addItem(aaa);
        cart.addItem(cd);
        cart.addItem(dvd);

        final Cashier cashier = context.getBean("cashier", Cashier.class);
        cashier.checkout(cart);
    }
}
