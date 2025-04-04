package com.znaji.recipe3;

import com.znaji.config.AppConfig;
import com.znaji.service.BookShop;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@Import(AppConfig.class)
@EnableTransactionManagement
@ComponentScan(basePackages = "com.znaji.recipe3")
public class Config {

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean
    public BookShop bookShop(DataSource dataSource, PlatformTransactionManager transactionManager) {
        BookShopJdbcTemplateImpl bookShopJdbcTemplate = new BookShopJdbcTemplateImpl();
        bookShopJdbcTemplate.setDataSource(dataSource);
        bookShopJdbcTemplate.setTransactionManager(transactionManager);
        return bookShopJdbcTemplate;
    }

}
