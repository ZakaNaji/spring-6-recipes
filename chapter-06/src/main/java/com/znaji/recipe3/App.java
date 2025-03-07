package com.znaji.recipe3;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        var vehicleDao = ctx.getBean(VehicleDao.class);

        System.out.println(vehicleDao.getColor("CAR2"));
    }
}
