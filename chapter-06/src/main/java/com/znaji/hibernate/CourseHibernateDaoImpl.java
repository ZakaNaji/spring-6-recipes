package com.znaji.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseHibernateDaoImpl implements CourseDao {

    @Override
    public Course store(Course course) {
        var session = getSession();
        try(session) {
            session.beginTransaction();
            if (course.getId() == null) {
                session.persist(course);
            } else {
                session.merge(course);
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
        var session = getSession();
        try (session) {
            session.beginTransaction();
            var course = session.get(Course.class, courseId);
            if (course != null) {
                session.remove(course);
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            session.getTransaction().rollback();
            throw e;
        }

    }

    @Override
    public Course findById(Long courseId) {
        var session = getSession();
        try (session) {
            return session.find(Course.class, courseId);
        }
    }

    @Override
    public List<Course> findAll() {
        try (var session = getSession()) {
            return session.createQuery("select c from Course c", Course.class).getResultList();
        }
    }

    @Lookup
    public Session getSession() {
        return null;
    }
}
