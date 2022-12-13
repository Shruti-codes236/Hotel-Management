package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.UserPhoneNumber;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class PhoneNoRepository {
    private final JdbcTemplate jdbcTemplate;

    public PhoneNoRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }


    public void addNo(UUID userID, String s) {
        String sql = "INSERT INTO UserPhoneNumber(userID, phoneNumber) values (?,?)";

        jdbcTemplate.update(sql, userID.toString(), s);
    }

    public List<UserPhoneNumber> getNo(UUID userID){
        String sql = "SELECT * from UserPhoneNumber where userID = ?";

        return  jdbcTemplate.query(sql, new Object[]{userID.toString()}, new BeanPropertyRowMapper<>(UserPhoneNumber.class));
    }
}
