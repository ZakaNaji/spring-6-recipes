package com.znaji.recipe1;

import com.znaji.config.AppConfig;
import com.znaji.service.BookShop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import javax.sql.DataSource;

@Configuration
@Import(AppConfig.class)
public class Config {
    @Bean
    public BookShop bookShop(DataSource dataSource) {
        return new BookShopJdbcImpl(dataSource);
    }

}
