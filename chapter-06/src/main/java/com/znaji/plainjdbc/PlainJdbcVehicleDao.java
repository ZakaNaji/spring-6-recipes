package com.znaji.plainjdbc;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PlainJdbcVehicleDao implements VehicleDao {

    private static final String INSERT_SQL = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) VALUES (?, ?, ?, ?)";
    private final DataSource dataSource;

    public PlainJdbcVehicleDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Vehicle vehicle) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SQL);
            preparedStatement(preparedStatement, vehicle);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }


    @Override
    public void update(Vehicle vehicle) {

    }

    @Override
    public void delete(Vehicle vehicle) {

    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return null;
    }

    @Override
    public List<Vehicle> findAll() {
        return null;
    }

    private void preparedStatement(PreparedStatement preparedStatement, Vehicle vehicle) {
        try {
            preparedStatement.setString(1, vehicle.getVehicleNo());
            preparedStatement.setString(2, vehicle.getColor());
            preparedStatement.setInt(3, vehicle.getWheel());
            preparedStatement.setInt(4, vehicle.getSeat());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
