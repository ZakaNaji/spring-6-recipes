package com.znaji.hibernateContxtualSession;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseDaoWithHibernateContextualSession implements CourseDao {

    private final SessionFactory sessionFactory;

    public CourseDaoWithHibernateContextualSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Course store(Course course) {
        var session = sessionFactory.getCurrentSession();
        if (course.getId() == null) {
            session.persist(course);
        } else {
            session.merge(course);
        }
        return course;
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
