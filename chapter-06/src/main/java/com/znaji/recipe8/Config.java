package com.znaji.recipe8;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.postgresql.Driver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
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
    CourseDao courseDao(SessionFactory sessionFactory) {
        return new CourseDaoHibernateImpl(sessionFactory);
    }
}
