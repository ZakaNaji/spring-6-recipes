package com.znaji.recipe6;

import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;

import java.util.List;

public class NameParamJdbcVehicleDaoImpl extends NamedParameterJdbcDaoSupport implements VehicleDao {
    private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR=:color,WHEEL=:wheel,SEAT=:seat WHERE VEHICLE_NO=:vehicleNo";

    @Override
    public void insert(Vehicle vehicle) {

    }

    @Override
    public void update(Vehicle vehicle) {
        var source = new BeanPropertySqlParameterSource(vehicle);
        getNamedParameterJdbcTemplate().update(UPDATE_SQL, source);
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
