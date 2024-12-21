package com.znaji.plainjdbc;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlainJdbcExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(PlainJdbcConfig.class);

        var vehicleDao = ctx.getBean(VehicleDao.class);
        //vehicleDao.insert(new Vehicle("CAR1", "RED", 4, 4));

        System.out.println(vehicleDao.findByVehicleNo("CAR1"));
        System.out.println("---after update----");
        vehicleDao.update(new Vehicle("CAR1", "BLUE", 4, 4));
        System.out.println(vehicleDao.findByVehicleNo("CAR1"));
        System.out.println("---after delete----");
        vehicleDao.delete(new Vehicle("CAR1", "BLUE", 4, 4));
        System.out.println(vehicleDao.findByVehicleNo("CAR1"));
    }
}
