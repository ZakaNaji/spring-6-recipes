package com.znaji.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpamanagerExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JpaManagerConfig.class);
        var courseDao = ctx.getBean(CourseDao.class);

        System.out.println("find course by id 4");
        var course = courseDao.findById(4L);
        System.out.println(course);
        System.out.println("update course 4");
        course.setTitle("Java 11");
        courseDao.store(course);
        System.out.println("find all courses");
        courseDao.findAll().forEach(System.out::println);
    }
}
