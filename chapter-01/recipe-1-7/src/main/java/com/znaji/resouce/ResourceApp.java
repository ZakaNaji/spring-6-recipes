package com.znaji.resouce;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ResourceApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(ResourceConfig.class);

        var bannerLoader = ctx.getBean(BannerLoader.class);
    }
}
