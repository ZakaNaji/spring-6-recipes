package com.znaji.recipe11;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        CourseDao courseDao = ctx.getBean(CourseDao.class);

        Course course = new Course();
        course.setTitle("Spring Data for dammies");
        course.setFee(350);
        course.setBeginDate(LocalDate.now());
        course.setEndDate(LocalDate.of(2025,12,30));

        course.setId(1L);

        courseDao.findAll().forEach(System.out::println);
    }
}
