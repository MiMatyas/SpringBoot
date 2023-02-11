package com.matyas.Shop;

import com.matyas.Shop.domain.Customer;
import com.matyas.Shop.domain.Merchant;
import com.matyas.Shop.domain.Product;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.*;
import java.time.Instant;
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_CLASS)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DBInsertTests {

    // prikazy pro databazi
    private final String insertCustomer = "INSERT INTO customer(name, surname, email, city, street, house_number,zipcode, age, phone_number) VALUES(?,?,?,?,?,?,?,?,?)";
    private final String insertMerchant = "INSERT INTO merchant(name, email, city, street, house_number,zipcode) VALUES(?,?,?,?,?,?)";
    private final String insertProduct = "INSERT INTO product(merchant_id, name, description, price, created_at, available) VALUES(?,?,?,?,?,?)";
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
                if (customer.getAge() != null){
                    preparedStatement.setInt(8,customer.getAge());
                }else {
                    preparedStatement.setNull(8, Types.INTEGER);
                }
                if (customer.getPhone() !=null){
                    preparedStatement.setInt(9,customer.getPhone());
                }else {
                    preparedStatement.setNull(9,Types.INTEGER);
                }
                return preparedStatement;
            }
        });
    }

    @Test
    public void createMerchant() {
        Merchant merchant = new Merchant();
        merchant.setName("Adam");
        merchant.setEmail("Adam");
        merchant.setCity("Adam");
        merchant.setStreet("Adam");
        merchant.setHouseNumber(66);
        merchant.setZipcode(88);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(insertMerchant);
                preparedStatement.setString(1, merchant.getName());
                preparedStatement.setString(2, merchant.getEmail());
                preparedStatement.setString(3, merchant.getCity());
                preparedStatement.setString(4, merchant.getStreet());
                preparedStatement.setInt(5, merchant.getHouseNumber());
                preparedStatement.setInt(6, merchant.getZipcode());
                return preparedStatement;
            }

            ;
        });
    }
    @Test
    public void createProduct(){
        Product product = new Product();
        product.setMerchantId(7);
        product.setName("Kondicioner");
        product.setDescription("Dopřejte svým vlasům péči.");
        product.setPrice(149.90);
        product.setCreatedAt(Timestamp.from(Instant.now()));
        product.setAvailable(5);

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(insertProduct);
                preparedStatement.setInt(1,product.getMerchantId());
                preparedStatement.setString(2,product.getName());
                preparedStatement.setString(3,product.getDescription());
                preparedStatement.setDouble(4,product.getPrice());
                preparedStatement.setTimestamp(5,product.getCreatedAt());
                preparedStatement.setInt(6,product.getAvailable());
                return preparedStatement;
            };
        });

    }


}
