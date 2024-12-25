package com.znaji.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JpaManagerConfig {

    @Bean
    EntityManagerFactory entityManagerFactory() {
        return Persistence.createEntityManagerFactory("course");
    }

    @Bean
    public CourseDao courseDao(EntityManagerFactory entityManagerFactory) {
        return new CourseJpaManagerDaoImpl(entityManagerFactory);
    }
}
