package com.znaji.recipe8;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public SessionFactory sessionFactory() {
        var configuration = new org.hibernate.cfg.Configuration()
                .setProperty(AvailableSettings.JAKARTA_JDBC_URL, "jdbc:postgresql://localhost:5432/spring_recipes")
                .setProperty(AvailableSettings.JAKARTA_JDBC_USER, "postgres")
                .setProperty(AvailableSettings.JAKARTA_JDBC_PASSWORD, "toor")
                .setProperty(AvailableSettings.SHOW_SQL, "true")
                .setProperty(AvailableSettings.HBM2DDL_AUTO, "update")
                .addAnnotatedClass(Course.class);
        return configuration.buildSessionFactory();
    }

    @Bean
    CourseDao courseDao() {
        return new CourseDaoHibernateImpl(sessionFactory());
    }
}
