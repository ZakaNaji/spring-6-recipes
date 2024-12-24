package com.znaji.jdbctemplate;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class JdbcTemplateExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(JdbcTemplateConfig.class);
        var vehicleDao = ctx.getBean("vehicleDaoNamedJdbcTemplate", VehicleDao.class);

        var vehicle = new Vehicle("CAR-005", "Maroon", 4, 4);

        System.out.println("Start inserting vehicle");
        vehicleDao.insert(vehicle);
        System.out.println("Vehicle inserted");
    }
}
