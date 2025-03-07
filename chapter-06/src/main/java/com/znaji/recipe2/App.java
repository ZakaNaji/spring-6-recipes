package com.znaji.recipe2;

import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var vehicleDao = ctx.getBean(VehicleDao.class);
        vehicleDao.findAll().forEach(System.out::println);
    }
}
