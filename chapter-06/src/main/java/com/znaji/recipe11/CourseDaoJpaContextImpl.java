package com.znaji.recipe11;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("courseDao")
public class CourseDaoJpaContextImpl implements CourseDao {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    @Transactional
    public Course store(Course course) {
        return entityManager.merge(course);
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
        return entityManager.createQuery("SELECT c from Course c", Course.class).getResultList();
    }
}
