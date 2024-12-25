package com.znaji.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AvailableSettings;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackages = "com.znaji.hibernate")
public class HibernateConfig {

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
    @Scope("prototype")
    public Session session(SessionFactory sessionFactory) {
        return sessionFactory.openSession();
    }
}
