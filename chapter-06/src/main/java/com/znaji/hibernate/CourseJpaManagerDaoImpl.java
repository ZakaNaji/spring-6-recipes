package com.znaji.hibernate;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Lookup;

import java.util.List;

public class CourseJpaManagerDaoImpl implements CourseDao{

    private final EntityManagerFactory entityManagerFactory;

    public CourseJpaManagerDaoImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public Course store(Course course) {
        var entityManager = entityManagerFactory.createEntityManager();
        var tx = entityManager.getTransaction();
        try {
            tx.begin();
            entityManager.persist(course);
            tx.commit();
            return course;
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public void delete(Long courseId) {

    }

    @Override
    public Course findById(Long courseId) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
