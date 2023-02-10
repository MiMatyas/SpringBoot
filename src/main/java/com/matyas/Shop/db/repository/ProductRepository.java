package com.matyas.Shop.db.repository;

import com.matyas.Shop.db.mapper.ProductRowMapper;
import com.matyas.Shop.db.service.api.request.UpdateProductRequest;
import com.matyas.Shop.domain.Product;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
@Component
public class ProductRepository {
    private JdbcTemplate jdbcTemplate;
    private ProductRowMapper productRowMapper = new ProductRowMapper();

    public ProductRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product getProduct(int id) {
        final String sql = "SELECT * FROM product WHERE product.id = " + id;
        try {
            return jdbcTemplate.queryForObject(sql, productRowMapper);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    public Integer add(Product product) {
        final String sql = "INSERT INTO product (merchant_id, name, description, price, created_at, available) VALUES(?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                preparedStatement.setInt(1, product.getMerchantId());
                preparedStatement.setString(2, product.getName());
                preparedStatement.setString(3, product.getDescription());
                preparedStatement.setDouble(4, product.getPrice());
                preparedStatement.setTimestamp(5, product.getCreatedAt());
                preparedStatement.setInt(6, product.getAvailable());
                return preparedStatement;
            }
        }, keyHolder);
        if (keyHolder.getKey() != null) {
            return keyHolder.getKey().intValue();
        } else {
            return null;
        }
    }

    public List<Product> getProducts() {
        final String sql = "SELECT * FROM product";

        return jdbcTemplate.query(sql, productRowMapper);
    }

    public void update(int id, UpdateProductRequest updateProductRequest) {
        final String sql = "UPDATE product SET name = ?, description = ?, price = ?, available = ? WHERE product.id = ?";
        jdbcTemplate.update(sql, updateProductRequest.getName(),updateProductRequest.getDescription(),updateProductRequest.getPrice(),updateProductRequest.getAvailable(), id);

    }
    public void delete(int id){
        final String sql = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}

























