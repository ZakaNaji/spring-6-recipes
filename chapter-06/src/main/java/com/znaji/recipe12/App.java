package com.znaji.recipe12;

import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        CourseRepository courseDao = ctx.getBean(CourseRepository.class);

        courseDao.findAll().forEach(System.out::println);
    }
}
