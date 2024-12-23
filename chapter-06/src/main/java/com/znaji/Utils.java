package com.znaji;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
