package com.matyas.Shop.db.repository;

import com.matyas.Shop.db.mapper.MerchanRowMapper;
import com.matyas.Shop.domain.Merchant;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

@Component
// vytvori MerchantRepository ve Spring kontextu, diky tomu muzeme MerchantRepository pouzit v inject dependency
public class MerchantRepository {
    private final JdbcTemplate jdbcTemplate;
    private final MerchanRowMapper merchanRowMapper = new MerchanRowMapper();
    public MerchantRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    public Merchant get(int id){
        final String sql = "SELECT * FROM merchant WHERE merchant.id = "+id;
        try {
            return jdbcTemplate.queryForObject(sql, merchanRowMapper);
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }
    public Integer add(Merchant merchant){
        final String sql = "INSERT INTO merchant (name, email, city, street, house_number, zipcode) VALUES (?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                preparedStatement.setString(1,merchant.getName());
                preparedStatement.setString(2,merchant.getEmail());
                preparedStatement.setString(3,merchant.getCity());
                preparedStatement.setString(4, merchant.getStreet());
                preparedStatement.setInt(5,merchant.getHouseNumber());
                preparedStatement.setInt(6,merchant.getZipcode());
                return preparedStatement;
            }
        }, keyHolder);
        if (keyHolder != null){
            return keyHolder.getKey().intValue();
        }else{
            return null;
        }

    }
    public List<Merchant> getMerchants(){
        final String sql = "SELECT * FROM merchant";
        return jdbcTemplate.query(sql, merchanRowMapper);
    }

}






















