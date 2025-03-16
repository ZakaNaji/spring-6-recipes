package com.znaji.recipe8;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.hibernate.SessionFactory;

import java.util.List;

public class CourseDaoHibernateImpl implements CourseDao {

    private final SessionFactory sessionFactory;

    public CourseDaoHibernateImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }

    @Override
    public Course store(Course course) {
        var session = sessionFactory.openSession();
        try (session) {
            session.getTransaction().begin();
            if (course.getId() != null) {
                session.merge(course);
            } else {
                session.persist(course);
            }
            session.getTransaction().commit();
            return course;
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void delete(Long courseId) {
        var session = sessionFactory.openSession();
        try (session) {
            session.getTransaction().begin();
            session.remove(courseId);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public Course findById(Long courseId) {
        try (var session = sessionFactory.openSession()) {
            return session.find(Course.class, courseId);
        }
    }

    @Override
    public List<Course> findAll() {
        try (var session = sessionFactory.openSession()) {
            return session.createQuery("SELECT c from Course c", Course.class).getResultList();
        }
    }
}
