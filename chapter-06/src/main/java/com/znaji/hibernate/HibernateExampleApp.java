package com.znaji.hibernate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class HibernateExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateConfig.class);

        var courseDao = ctx.getBean(CourseDao.class);
        var course = new Course();
        course.setTitle("Spring Framework");
        course.setBeginDate(java.time.LocalDate.now());
        course.setEndDate(java.time.LocalDate.now().plusMonths(3));
        course.setFee(1000);
        courseDao.store(course);
        System.out.println("Course stored: " + course);
    }
}
