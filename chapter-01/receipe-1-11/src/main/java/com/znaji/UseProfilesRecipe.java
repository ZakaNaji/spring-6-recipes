package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

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
        //context.getEnvironment().setDefaultProfiles("autumn");
        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        propertySources.addFirst(new CustomPropertySource());
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
