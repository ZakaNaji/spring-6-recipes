package com.znaji.recipe8;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var courseDao = ctx.getBean(CourseDao.class);

        Course course = new Course();
        course.setTitle("Spring Framework for dammies");
        course.setFee(250);
        course.setBeginDate(LocalDate.now());
        course.setEndDate(LocalDate.of(2025,12,30));
        courseDao.store(course);

        courseDao.findAll().forEach(System.out::println);
    }
}
