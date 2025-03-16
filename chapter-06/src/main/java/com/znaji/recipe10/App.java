package com.znaji.recipe10;

import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);

        CourseDao courseDao = ctx.getBean(CourseDao.class);

        System.out.println(courseDao.findById(10L));
    }
}
