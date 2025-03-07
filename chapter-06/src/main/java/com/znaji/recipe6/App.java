package com.znaji.recipe6;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(Config.class);
        VehicleDao vehicleDao = ctx.getBean(VehicleDao.class);
        var vehicle = new Vehicle();
        vehicle.setVehicleNo("CAR2");
        vehicle.setSeat(10);
        vehicle.setWheel(6);
        vehicle.setColor("Black");
        vehicleDao.update(vehicle);
    }
}
