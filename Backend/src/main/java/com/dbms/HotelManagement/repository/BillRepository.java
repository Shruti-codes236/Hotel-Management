package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Bill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Repository
public class BillRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BillRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addBill(UUID billID, UUID bookingID, int amount, LocalDate bDate, LocalTime bTime){
        String sql = "INSERT INTO Bill(billID, bookingID, amount, bDate, bTime) values (?,?,?,?,?)";

        jdbcTemplate.update(sql, billID.toString(), bookingID.toString(), amount, bDate, bTime);
    }

    public Bill getBill(UUID bookingID){
        String sql = "";
        try{
            return jdbcTemplate.queryForObject(sql, new Object[]{bookingID.toString()}, new BeanPropertyRowMapper<>(Bill.class));
        }
        catch(Exception e){
            System.out.println(e);
            return new Bill();
        }
//        return ;
    }

}
