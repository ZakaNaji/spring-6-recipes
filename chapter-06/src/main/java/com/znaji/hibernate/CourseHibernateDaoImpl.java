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

    }

    @Override
    public Course findById(Long courseId) {
        return null;
    }

    @Override
    public List<Course> findAll() {
        return null;
    }

    @Lookup
    public Session getSession() {
        return null;
    }
}
