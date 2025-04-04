package com.znaji.recipe3;

import com.znaji.service.BookShop;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

public class BookShopJdbcTemplateImpl extends JdbcDaoSupport implements BookShop {

    private PlatformTransactionManager transactionManager;

    @Override
    public void purchase(String isbn, String username) {
        DefaultTransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(transactionDefinition);
        try {

            Integer price = getJdbcTemplate().queryForObject("SELECT price FROM book WHERE isbn = ?", Integer.class, isbn);

            getJdbcTemplate().update("UPDATE book_stock SET stock = stock - 1 WHERE isbn = ?", isbn);

            getJdbcTemplate().update("UPDATE account SET balance = balance - ? WHERE username = ?", price, username);

            transactionManager.commit(status);

        } catch (DataAccessException e) {
            transactionManager.rollback(status);
            throw new RuntimeException(e);
        }
    }


    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }
}
