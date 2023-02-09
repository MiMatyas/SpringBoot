package com.matyas.Shop.db.repository;

import com.matyas.Shop.db.mapper.CustomerRowMapper;
import com.matyas.Shop.db.service.api.request.UpdateCustomerRequest;
import com.matyas.Shop.domain.Customer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.List;

@Component // vytvori CustomerRepository ve Spring kontextu, diky tomu muzeme CustomerRepository pouzit v inject dependency
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;
    private final CustomerRowMapper customerRowMapper = new CustomerRowMapper();
    public CustomerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public Customer get(int id) {
        final String sql = "SELECT * FROM customer WHERE customer.id = " + id;
        try {
            return jdbcTemplate.queryForObject(sql, customerRowMapper);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }
    public Integer add(Customer customer){
        final String sql = "INSERT INTO customer (name,surname,email,city,street,house_number,zipcode,age,phone_number) VALUES(?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder(); // zachyti zvolenou hodnotu pro nasledne vyuziti
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);// keyholder zachytava id
                preparedStatement.setString(1,customer.getName());
                preparedStatement.setString(2,customer.getSurname());
                preparedStatement.setString(3,customer.getEmail());
                preparedStatement.setString(4,customer.getCity());
                preparedStatement.setString(5,customer.getStreet());
                preparedStatement.setInt(6,customer.getHouseNumber());
                preparedStatement.setInt(7,customer.getZipcode());
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
        },keyHolder
        );
        if (keyHolder != null){
            return keyHolder.getKey().intValue(); // keyholder vraci id ktere drive zachytil
        }else{
            return null;
        }

    }
    public List<Customer> getCustomers(){
        final String sql = "SELECT * FROM customer";


        return jdbcTemplate.query(sql,customerRowMapper);
    }
    public void delete(int id){
        final String sql = "DELETE FROM customer WHERE customer.id = id";
        jdbcTemplate.update(sql, id);
            }
    public void update(int id, UpdateCustomerRequest updateCustomerRequest){
        final String sql = "UPDATE customer SET (name = ?, surname = ?, email = ?, city = ?, street = ?, house_number = ?, zipcode = ?, age = ?, phone_number = ?) WHERE id = " + id;
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql);
                preparedStatement.setString(1,updateCustomerRequest.getName());
                preparedStatement.setString(2,updateCustomerRequest.getSurname());
                preparedStatement.setString(3,updateCustomerRequest.getEmail());
                preparedStatement.setString(4,updateCustomerRequest.getCity());
                preparedStatement.setString(5,updateCustomerRequest.getStreet());
                preparedStatement.setInt(6,updateCustomerRequest.getHouseNumber());
                preparedStatement.setInt(7,updateCustomerRequest.getZipcode());
                if (updateCustomerRequest.getAge() != null){
                    preparedStatement.setInt(8,updateCustomerRequest.getAge());
                }else {
                    preparedStatement.setNull(8,Types.INTEGER);
                }
                if (updateCustomerRequest.getPhone() != null){
                    preparedStatement.setInt(9,updateCustomerRequest.getPhone());
                }else {
                    preparedStatement.setNull(9,Types.INTEGER);
                }

                return preparedStatement;
            }
        });
    }


}
