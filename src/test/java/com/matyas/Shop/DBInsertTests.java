package com.matyas.Shop;

import com.matyas.Shop.domain.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DBInsertTests {

    private final String insertCustomer = "INSERT INTO customer(name, surname, email, city, street, house_number,zipcode, age, phone_number) VALUES(?,?,?,?,?,?,?,?,?)";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void createCustomer() {
        Customer customer = new Customer();
        customer.setName("Novak");
        customer.setSurname("Novak");
        customer.setEmail("Novak");
        customer.setCity("Novak");
        customer.setStreet("Novak");
        customer.setHouseNumber(555);
        customer.setZipcode(444);
        customer.setAge(33);
        customer.setPhone(777);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(insertCustomer);
                preparedStatement.setString(1, customer.getName());
                preparedStatement.setString(2, customer.getSurname());
                preparedStatement.setString(3, customer.getEmail());
                preparedStatement.setString(4, customer.getCity());
                preparedStatement.setString(5, customer.getStreet());
                preparedStatement.setInt(6, customer.getHouseNumber());
                preparedStatement.setInt(7, customer.getZipcode());
                preparedStatement.setInt(8, customer.getAge());
                preparedStatement.setInt(9,customer.getPhone());
                return preparedStatement;
            }
        });
    }
}
