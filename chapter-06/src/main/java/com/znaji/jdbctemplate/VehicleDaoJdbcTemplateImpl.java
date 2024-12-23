package com.znaji.jdbctemplate;

import com.znaji.Utils;
import com.znaji.Vehicle;
import com.znaji.VehicleDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public class VehicleDaoJdbcTemplateImpl implements VehicleDao {

    private static final String INSERT_SQL = "INSERT INTO VEHICLE (COLOR, WHEEL, SEAT,VEHICLE_NO) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_SQL = "UPDATE VEHICLE SET COLOR=?,WHEEL=?,SEAT=? WHERE VEHICLE_NO=?";
    private static final String SELECT_ALL_SQL = "SELECT * FROM VEHICLE";
    private static final String SELECT_ONE_SQL = "SELECT * FROM VEHICLE WHERE VEHICLE_NO = ?";
    private static final String DELETE_SQL = "DELETE FROM VEHICLE WHERE VEHICLE_NO=?";

    private final JdbcTemplate jdbcTemplate;

    public VehicleDaoJdbcTemplateImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void insert(Vehicle vehicle) {
        //we did use PreparedStatementCreator
        jdbcTemplate.update(con -> {
            var ps = con.prepareStatement(INSERT_SQL);
            Utils.preparedStatement(ps, vehicle);
            return ps;
        });
    }

    @Override
    public void update(Vehicle vehicle) {
        // we did use PreparedStatementSetter
        jdbcTemplate.update(UPDATE_SQL, ps -> {
            Utils.preparedStatement(ps, vehicle);
        });
    }

    @Override
    public void insert(Collection<Vehicle> vehicles) {
        // we did use BatchPreparedStatementSetter
        jdbcTemplate.batchUpdate(INSERT_SQL, vehicles, vehicles.size(), Utils::preparedStatement);
    }

    @Override
    public Vehicle findByVehicleNo(String vehicleNo) {
        return jdbcTemplate.queryForObject(SELECT_ONE_SQL,
                (rs, rowNum) -> Utils.toVehicle(rs),
                vehicleNo);
    }

    @Override
    public List<Vehicle> findAll() {
        return jdbcTemplate.query(SELECT_ALL_SQL, new BeanPropertyRowMapper<>(Vehicle.class));
    }

    @Override
    public void delete(Vehicle vehicle) {
        // Delete vehicle
    }

}
