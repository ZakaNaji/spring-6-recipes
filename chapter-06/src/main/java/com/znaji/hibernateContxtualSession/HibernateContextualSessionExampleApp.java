package com.znaji.hibernateContxtualSession;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class HibernateContextualSessionExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(HibernateContextualSessionConfig.class);
        var courseDao = ctx.getBean(CourseDao.class);

        var course = new Course();
        course.setTitle("Spring Recipes");
        course.setBeginDate(LocalDate.of(2021, 1, 1));
        course.setEndDate(LocalDate.of(2021, 12, 31));
        course.setFee(1560);
        courseDao.store(course);
        System.out.println("Course stored: " + course);
    }
}
