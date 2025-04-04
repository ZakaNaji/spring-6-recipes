package com.znaji.recipe5;

import com.znaji.config.AppConfig;
import com.znaji.service.BookShop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Import(AppConfig.class)
@EnableTransactionManagement
public class Config {

    @Bean
    public PlatformTransactionManager platformTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public BookShop bookShop(DataSource dataSource) {
        BookShopDeclarativeImpl bookShopDeclarative = new BookShopDeclarativeImpl();
        bookShopDeclarative.setDataSource(dataSource);
        return bookShopDeclarative;
    }
}
