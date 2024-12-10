package com.znaji.resouce;

import jakarta.annotation.PostConstruct;
import org.springframework.core.io.Resource;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class BannerLoader {

    private Resource banner;

    public BannerLoader(Resource banner) {
        this.banner = banner;
    }

    @PostConstruct
    public void loadBanner() throws Exception {
        var path = Paths.get(banner.getURI());
        try (var lines = Files.lines(path, StandardCharsets.UTF_8)) {
            lines.forEachOrdered(System.out::println);
        }
    }
}
