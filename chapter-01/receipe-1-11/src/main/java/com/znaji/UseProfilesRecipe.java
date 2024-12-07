package com.znaji;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.env.MutablePropertySources;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class UseProfilesRecipe
{
    public static void main( String[] args )
    {
        var context = new AnnotationConfigApplicationContext();
        MutablePropertySources propertySources = context.getEnvironment().getPropertySources();
        try {
            propertySources.addFirst(new DynamicFilePropertyResolver("dynamicFilePropertyResolver", "dev"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        context.getEnvironment().getProperty("app.name");

    }
}
