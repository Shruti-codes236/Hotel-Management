package com.dbms.HotelManagement.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class MemberRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void registerMember(UUID bookingID, String aadharNo, int age, String fname, String lname){
        String sql = "INSERT INTO Member (aadharNo, age, fname,lname, bookingID) values (?, ?, ?, ?, ?)";

        try{
            jdbcTemplate.update(sql, aadharNo, age, fname, lname, bookingID.toString());
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public int getCountMember(UUID bookingID){
        String sql = "SELECT count(*) from Member where bookingID = ?";

        try{
            int c = jdbcTemplate.queryForObject(sql, new Object[]{bookingID.toString()}, Integer.class);
            System.out.println(c);
            return c;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return 0;

    }


//    public
}
