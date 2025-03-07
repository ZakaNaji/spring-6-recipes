package com.znaji.recipe2;

import com.znaji.Utils;
import com.znaji.Vehicle;
import com.znaji.VehicleDao;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlainJdbcVehicleDaoImpl implements VehicleDao {

    private DataSource dataSource;

    public PlainJdbcVehicleDaoImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void insert(Vehicle vehicle) {

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
        try (var con = dataSource.getConnection()) {
            PreparedStatement preparedStatement = con.prepareStatement("SELECT * FROM VEHICLE");
            var vehicles = new ArrayList<Vehicle>();
            try (var rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    vehicles.add(Utils.toVehicle(rs));
                }
            }

            return vehicles;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
