package com.matyas.Shop.db.mapper;

import com.matyas.Shop.domain.Customer;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<Customer> {
    @Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
        Customer customer = new Customer();
        customer.setId(rs.getInt("id"));
        customer.setName(rs.getString("name"));
        customer.setSurname(rs.getString("surname"));
        customer.setEmail(rs.getString("email"));
        customer.setCity(rs.getString("city"));
        customer.setStreet(rs.getString("street"));
        customer.setHouseNumber(rs.getInt("house_number"));
        customer.setZipcode(rs.getInt("zipcode"));
        customer.setAge(rs.getObject("age") == null? null : rs.getInt("age"));
        customer.setPhone(rs.getObject("phone") == null? null : rs.getInt("phone"));
        return customer;
    }
}
