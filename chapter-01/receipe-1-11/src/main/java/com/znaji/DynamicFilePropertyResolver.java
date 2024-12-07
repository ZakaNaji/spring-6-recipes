package com.znaji;

import org.springframework.core.env.PropertySource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Properties;

public class DynamicFilePropertyResolver extends PropertySource<Object> {

    private final Properties properties = new Properties();

    public DynamicFilePropertyResolver(String name, String env) throws IOException {
        super(name);
        var path = Path.of("src/main/resources", env + ".properties");
        if (Files.exists(path)) {
            properties.load(Files.newBufferedReader(path));
        }
    }

    @Override
    public Object getProperty(String name) {
        return properties.getProperty(name);
    }
}
