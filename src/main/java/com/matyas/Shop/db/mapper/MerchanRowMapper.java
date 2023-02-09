package com.matyas.Shop.db.mapper;

import com.matyas.Shop.domain.Merchant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MerchanRowMapper implements RowMapper<Merchant> {
    @Override
    public Merchant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Merchant merchant = new Merchant();
        merchant.setId(rs.getInt("id"));
        merchant.setName(rs.getString("name"));
        merchant.setEmail(rs.getString("email"));
        merchant.setCity(rs.getString("city"));
        merchant.setStreet(rs.getString("street"));
        merchant.setHouseNumber(rs.getInt("house_number"));
        merchant.setZipcode(rs.getInt("zipcode"));
        return merchant;
    }
}
