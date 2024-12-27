package com.znaji.jpaContextInjection;

import com.znaji.hibernate.Course;
import com.znaji.hibernate.CourseDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.List;

public class JpaContextInjectionExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JpaContextInjectionConfig.class);
        CourseDao courseDao = ctx.getBean(CourseDao.class);

        List<Course> all = courseDao.findAll();
        all.forEach(System.out::println);
    }
}
