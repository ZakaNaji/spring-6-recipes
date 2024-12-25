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
    @Transactional
    public void delete(Long courseId) {
        var session = sessionFactory.getCurrentSession();
        var course = session.get(Course.class, courseId);
        session.remove(course);
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long courseId) {
        var session = sessionFactory.getCurrentSession();
        return session.get(Course.class, courseId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        var session = sessionFactory.getCurrentSession();
        return session.createQuery("from Course", Course.class).list();
    }
}
