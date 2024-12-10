package com.znaji.resouce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;

public class ResourceApp {
    public static void main(String[] args) throws IOException {
        //var ctx = new AnnotationConfigApplicationContext(ResourceConfig.class);
        //var bannerLoader = ctx.getBean(BannerLoader.class);

        var resource = new ClassPathResource("discounts.properties");
        var properties = PropertiesLoaderUtils.loadProperties(resource);
        System.out.println(properties);
    }
}
