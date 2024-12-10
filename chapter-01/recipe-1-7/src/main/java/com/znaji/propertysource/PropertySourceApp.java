package com.znaji.propertysource;

import com.znaji.Disc;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

public class PropertySourceApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(PropertySourceConfig.class);

        var dvd = ctx.getBean("dvd", Disc.class);
        System.out.println(dvd);

    }
}
