package com.znaji.resouce;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

@Configuration
public class ResourceConfig {

    @Value("classpath:banner.txt")
    private Resource banner;

    @Bean
    public BannerLoader bannerLoader() {
        return new BannerLoader(banner);
    }

}
