package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class UseProfilesRecipe
{
    public static void main( String[] args )
    {
        var context = new AnnotationConfigApplicationContext();
        //context.getEnvironment().setActiveProfiles("winter");
        context.register(MainConfig.class);
        context.refresh();

        var cashier = context.getBean(Cashier.class);
        System.out.println(cashier);

        var products = context.getBean("aaa", Product.class);
        System.out.println(products);

        products = context.getBean("cdrw", Product.class);
        System.out.println(products);

    }
}
