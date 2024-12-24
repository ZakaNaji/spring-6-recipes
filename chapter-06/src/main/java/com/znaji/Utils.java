package com.znaji;

import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class Utils {

    public static void preparedStatement(PreparedStatement ps, Vehicle vehicle) {
        try {
            ps.setString(1, vehicle.getColor());
            ps.setInt(2, vehicle.getWheel());
            ps.setInt(3, vehicle.getSeat());
            ps.setString(4, vehicle.getVehicleNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Vehicle toVehicle(ResultSet rs) {
        try {
            return new Vehicle(rs.getString("VEHICLE_NO"), rs.getString("COLOR"), rs.getInt("WHEEL"), rs.getInt("SEAT"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static Map<String, ?> toParamMap(Vehicle vehicle) {
        return Map.of(
                "vehicleNo", vehicle.getVehicleNo(),
                "color", vehicle.getColor(),
                "wheel", vehicle.getWheel(),
                "seat", vehicle.getSeat());
    }
}
