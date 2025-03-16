package com.znaji.recipe10;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("courseDao")
public class CourseDaoHibernateContextSessionImpl implements CourseDao {

    private final SessionFactory sessionFactory;

    public CourseDaoHibernateContextSessionImpl(SessionFactory sessionFactory) {
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
    @Transactional
    public Course findById(Long courseId) {
        var session = sessionFactory.getCurrentSession();
        return session.find(Course.class, courseId);
    }

    @Override
    public List<Course> findAll() {
        return null;
    }
}
