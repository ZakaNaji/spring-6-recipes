package com.znaji.jpaContextInjection;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseDaoJpaContextInjectionImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Course store(Course course) {
        return entityManager.merge(course);
    }

    @Override
    @Transactional
    public void delete(Long courseId) {
        Course course = entityManager.find(Course.class, courseId);
        entityManager.remove(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long courseId) {
        return entityManager.find(Course.class, courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c", Course.class);
        return query.getResultList();
    }
}
