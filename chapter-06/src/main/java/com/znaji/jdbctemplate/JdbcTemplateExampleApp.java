package com.znaji.jdbctemplate;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JdbcTemplateExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        var vehicleDao = ctx.getBean(VehicleDao.class);

        // Insert a vehicle
        System.out.println("Inserting a vehicle...");
        vehicleDao.insert(new Vehicle("001", "Red", 4, 4));
    }
}
