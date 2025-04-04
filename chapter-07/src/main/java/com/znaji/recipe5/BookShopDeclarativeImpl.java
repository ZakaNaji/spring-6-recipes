package com.znaji.recipe5;

import com.znaji.service.BookShop;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.annotation.Transactional;

public class BookShopDeclarativeImpl extends JdbcDaoSupport implements BookShop {
    @Override
    @Transactional
    public void purchase(String isbn, String username) {
        Integer price = getJdbcTemplate().queryForObject("SELECT price FROM book WHERE isbn = ?", Integer.class, isbn);

        getJdbcTemplate().update("UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?", isbn);

        getJdbcTemplate().update("UPDATE account SET balance = balance - ? WHERE username = ?", price, username);
    }
}
