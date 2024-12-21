package com.znaji;

import java.util.Collection;
import java.util.List;

public interface VehicleDao {
    void insert(Vehicle vehicle);
    void update(Vehicle vehicle);
    void delete(Vehicle vehicle);
    Vehicle findByVehicleNo(String vehicleNo);
    List<Vehicle> findAll();
    default void insert(Collection<Vehicle> vehicles) {
        vehicles.forEach(this::insert);
    }
}
