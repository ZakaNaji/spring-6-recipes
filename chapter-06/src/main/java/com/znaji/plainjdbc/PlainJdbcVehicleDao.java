package com.znaji.plainjdbc;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class PlainJdbcVehicleDao implements VehicleDao {

    private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL, SEAT,VEHICLE_NO) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR=?,WHEEL=?,SEAT=? WHERE VEHICLE_NO=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
    private static final String SELECT_ONE_SQL = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
    private static final String DELETE_SQL = "DELETE FROM VEHICLE WHERE VEHICLE_NO=?";
    private final DataSource dataSource;

    public PlainJdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement(preparedStatement, vehicle);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void update(Vehicle vehicle) {
        try (var con = dataSource.getConnection()) {
            var ps = con.prepareStatement(UPDATE_SQL);
            preparedStatement(ps, vehicle);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Vehicle vehicle) {
        try (var con = dataSource.getConnection()) {
            var ps = con.prepareStatement(DELETE_SQL);
            ps.setString(1, vehicle.getVehicleNo());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        try (var con = dataSource.getConnection()) {
            var ps = con.prepareStatement(SELECT_ONE_SQL);
            ps.setString(1, vehicleNo);
            Vehicle vehicle = null;
            try (var rs = ps.executeQuery()) {
                if (rs.next()) {
                    vehicle = toVehicle(rs);
                }
            }
            return vehicle;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public List<Vehicle> findAll() {
        try (var con = dataSource.getConnection()) {
            var ps = con.prepareStatement(SELECT_ALL_SQL);
            var vehicles = new java.util.ArrayList<Vehicle>();
            try (var rs = ps.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(toVehicle(rs));
                }
            }
            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void preparedStatement(PreparedStatement ps, Vehicle vehicle) {
        try {
            ps.setString(1, vehicle.getColor());
            ps.setInt(2, vehicle.getWheel());
            ps.setInt(3, vehicle.getSeat());
            ps.setString(4, vehicle.getVehicleNo());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Vehicle toVehicle(ResultSet rs) {
        try {
            return new Vehicle(rs.getString("VEHICLE_NO"), rs.getString("COLOR"), rs.getInt("WHEEL"), rs.getInt("SEAT"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
