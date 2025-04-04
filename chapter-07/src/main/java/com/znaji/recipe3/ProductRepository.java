package com.znaji.recipe3;

import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

@Repository
public class ProductRepository extends JdbcDaoSupport {

    private final DataSource dataSource;

    public ProductRepository(DataSource dataSource) {
        this.dataSource = dataSource;
        setDataSource(dataSource);
    }

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public void addProduct(String name, int price) {
        var query = "INSERT INTO product (name, price) VALUES (?, ?)";
        getJdbcTemplate().update(query, name, price);
    }

}
