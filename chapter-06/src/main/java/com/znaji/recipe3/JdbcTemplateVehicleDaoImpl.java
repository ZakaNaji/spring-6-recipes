package com.znaji.recipe3;

import com.znaji.Utils;
import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class JdbcTemplateVehicleDaoImpl implements VehicleDao {
    private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL, SEAT,VEHICLE_NO) VALUES (?, ?, ?, ?)";

    private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
    private JdbcTemplate jdbcTemplate;

    public JdbcTemplateVehicleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Vehicle vehicle) {
        jdbcTemplate.update(
                con -> {
                    var ps = con.prepareStatement(INSERT_SQL);
                    Utils.preparedStatement(ps, vehicle);
                    return ps;
                });
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
        return jdbcTemplate.query(SELECT_ALL_SQL, (rs, rowNum) -> {
            return Utils.toVehicle(rs);
        });
    }
}
