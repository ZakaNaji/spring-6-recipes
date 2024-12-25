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
            entityManager.merge(course);
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
        var entityManager = entityManagerFactory.createEntityManager();
        var tx = entityManager.getTransaction();
        try {
            tx.begin();
            var course = entityManager.find(Course.class, courseId);
            entityManager.remove(course);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public Course findById(Long courseId) {
        try (var entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.find(Course.class, courseId);
        }
    }

    @Override
    public List<Course> findAll() {
        try (var entityManager = entityManagerFactory.createEntityManager()) {
            return entityManager.createQuery("select c from Course c", Course.class).getResultList();
        }
    }
}
