package com.znaji.plainjdbc;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PlainJdbcExampleApp {
    public static void main(String[] args) {
        var ctx = new AnnotationConfigApplicationContext(PlainJdbcConfig.class);

        var vehicleDao = ctx.getBean(VehicleDao.class);
        vehicleDao.insert(new Vehicle("CAR1", "RED", 4, 4));
    }
}
