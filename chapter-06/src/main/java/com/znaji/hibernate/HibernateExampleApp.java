package com.znaji.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);

        var courseDao = ctx.getBean(CourseDao.class);
        var course = courseDao.findById(2L);
        System.out.println(course);
        course.setTitle("Java for dummies");
        courseDao.store(course);
        System.out.println("after update: " + courseDao.findById(2L));
    }
}
