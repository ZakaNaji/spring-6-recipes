package com.znaji.recipe2;

import com.znaji.VehicleDao;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import javax.sql.DataSource;

@Configuration
@ComponentScan
public class Config {

    @Bean
    public DataSource dataSource() {
        var dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/vehicle");
        dataSource.setUsername("postgres");
        dataSource.setPassword("toor");
        return dataSource;
    }

    @Bean
    public VehicleDao plainJdbcVehicleDao() {
        return new PlainJdbcVehicleDaoImpl(dataSource());
    }

}
