package com.znaji.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JpamanagerExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JpaManagerConfig.class);
        var courseDao = ctx.getBean(CourseDao.class);

        var course = new Course();
        course.setTitle("Java Persistence API");
        course.setBeginDate(java.time.LocalDate.now());
        course.setEndDate(java.time.LocalDate.now().plusMonths(3));
        course.setFee(1000);

        System.out.println("start storing course");
        courseDao.store(course);
    }
}
