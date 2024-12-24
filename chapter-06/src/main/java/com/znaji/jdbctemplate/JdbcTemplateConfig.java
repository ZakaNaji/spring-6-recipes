package com.znaji.jdbctemplate;

import com.znaji.VehicleDao;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.znaji.jdbctemplate")
public class JdbcTemplateConfig {

    @Bean
    public DataSource dataSource() {
        var dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/vehicle");
        dataSource.setUsername("postgres");
        dataSource.setPassword("toor");
        return dataSource;
    }

    // JdbcTemplate bean definition
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public VehicleDao vehicleDaoNamedJdbcTemplate(JdbcTemplate jdbcTemplate) {
        var vehicleDao = new VehicleNamedJdbcTemplateDao();
        vehicleDao.setJdbcTemplate(jdbcTemplate);
        return vehicleDao;
    }
}
