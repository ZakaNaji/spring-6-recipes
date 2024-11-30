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
        final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        final ProductService productService = context.getBean(ProductService.class);
        productService.sayHello();



    }
}
