package com.znaji.jdbctemplate;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcTemplateExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        var vehicleDao = ctx.getBean(VehicleDao.class);

        // Insert a vehicle
        System.out.println("Insert A list of vehicles");
        List<Vehicle> vehicles = List.of(
                new Vehicle("CAR1", "RED", 4, 4),
                new Vehicle("CAR2", "BLUE", 4, 4),
                new Vehicle("CAR3", "GREEN", 4, 4)
        );
        vehicleDao.insert(vehicles);
        System.out.println("Vehicles inserted");
        var allVehicles = vehicleDao.findAll();
        allVehicles.forEach(System.out::println);
    }
}
