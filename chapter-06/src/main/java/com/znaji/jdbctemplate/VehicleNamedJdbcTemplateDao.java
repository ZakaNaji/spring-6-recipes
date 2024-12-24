package com.znaji.jdbctemplate;

import com.znaji.Utils;
import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.List;

public class VehicleNamedJdbcTemplateDao extends NamedParameterJdbcDaoSupport implements VehicleDao {
    private static final String INSERT_SQL = "INSERT INTO VEHICLE (VEHICLE_NO, COLOR, WHEEL, SEAT) VALUES (:vehicleNo, :color, :wheel, :seat)";

    @Override
    public void insert(Vehicle vehicle) {
        getNamedParameterJdbcTemplate().update(INSERT_SQL, Utils.toParamMap(vehicle));
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

}
