package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config2.class);

        final Product cdrw = context.getBean("cdrw", Product.class);
        System.out.println("discounted cdrw: " + cdrw);



    }
}
