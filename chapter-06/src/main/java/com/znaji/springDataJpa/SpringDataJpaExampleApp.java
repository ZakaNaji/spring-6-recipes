package com.znaji.springDataJpa;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringDataJpaExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(SpringDataConfig.class);

        var courseRepo = ctx.getBean(CourseRepository.class);
        var allCourses = courseRepo.findAll();
        allCourses.forEach(System.out::println);
    }
}
