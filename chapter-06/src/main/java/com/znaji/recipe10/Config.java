package com.znaji.recipe10;

import com.znaji.hibernate.Course;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.znaji.recipe10")
@EnableTransactionManagement
public class Config {

    @Bean
    public DataSource dataSource() {
        var dataSource = new SimpleDriverDataSource();
        dataSource.setDriverClass(Driver.class);
        dataSource.setUrl("jdbc:postgresql://localhost:5432/spring_recipes");
        dataSource.setUsername("postgres");
        dataSource.setPassword("toor");
        return dataSource;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource) {
        return new LocalSessionFactoryBuilder(dataSource)
                .addAnnotatedClasses(Course.class)
                .addProperties(hibernateProperties())
                .buildSessionFactory();
    }

    private Properties hibernateProperties() {
        var props = new Properties();
        props.setProperty(AvailableSettings.SHOW_SQL, String.valueOf(true));
        props.setProperty(AvailableSettings.HBM2DDL_AUTO, "update");
        return props;
    }

    @Bean
    public HibernateTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }


}
