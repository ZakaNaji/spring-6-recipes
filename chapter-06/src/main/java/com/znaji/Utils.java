package com.znaji;

import java.sql.PreparedStatement;
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
}
