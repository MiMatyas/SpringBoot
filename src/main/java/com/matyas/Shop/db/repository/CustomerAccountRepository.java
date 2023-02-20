package com.matyas.Shop.db.repository;

import com.matyas.Shop.domain.CustomerAccount;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class CustomerAccountRepository {
    private JdbcTemplate jdbcTemplate;

    public CustomerAccountRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public void add(CustomerAccount customerAccount){
        final String sql = "INSERT INTO customer_account(customer_id, money) VALUES(?,?)";
        jdbcTemplate.update(sql,customerAccount.getCustomerId(),customerAccount.getMoney());
    }
    @Nullable
    public Double getMoney(int customerId){
        final String sql = "SELECT money FROM customer_account WHERE customer_id = "+customerId;
        try{
            return jdbcTemplate.queryForObject(sql, Double.class);
        }catch (DataAccessException e){
            return null;
        }
    }
    public void setMoney(int customerId, double money){
        final String sql = "UPDATE customer_account SET money = ? WHERE customer_id = ?";
        jdbcTemplate.update(sql, money, customerId);


    }
}
