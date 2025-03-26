package com.znaji.recipe1;

import com.znaji.service.BookShop;

import javax.sql.DataSource;
import java.sql.SQLException;

public class BookShopJdbcImpl implements BookShop {

    private final DataSource dataSource;

    public BookShopJdbcImpl(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void purchase(String isbn, String username) {
        try (var conn = dataSource.getConnection()) {
            int price;
            var selectPriceQuery = "SELECT price FROM book where isbn = ?";
            var pricePreparedStatement = conn.prepareStatement(selectPriceQuery);
            pricePreparedStatement.setString(1, isbn);
            try (var res = pricePreparedStatement.executeQuery()) {
                res.next();
                price = res.getInt("price");
            }

            var updateStockQuery = "UPDATE book_stock set stock = stock - 1 where isbn=?";
            var updateStockPreparedStatement = conn.prepareStatement(updateStockQuery);
            updateStockPreparedStatement.setString(1, isbn);
            updateStockPreparedStatement.executeUpdate();

            var updateAccountQuery = "UPDATE account set balance = balance - ? where username = ?";
            var updateAccountPreparedStatement =  conn.prepareStatement(updateAccountQuery);
            updateAccountPreparedStatement.setInt(1, price);
            updateAccountPreparedStatement.setString(2, username);
            updateAccountPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
