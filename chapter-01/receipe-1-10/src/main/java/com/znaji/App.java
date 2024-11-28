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
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config1.class);

        final Product cdrw = context.getBean("cdrw", Product.class);
        final Product dvdrw = context.getBean("dvdrw", Product.class);
        final Product aaa = context.getBean("aaa", Product.class);
        final Product aa = context.getBean("aa", Product.class);

        System.out.println(cdrw);
        System.out.println(dvdrw);
        System.out.println(aaa);
        System.out.println(aa);

    }
}
