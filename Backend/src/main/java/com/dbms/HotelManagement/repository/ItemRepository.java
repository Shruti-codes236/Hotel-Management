package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.ContactUs;
import com.dbms.HotelManagement.model.Items;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemRepository {

    public final JdbcTemplate jdbcTemplate;

    public ItemRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Items> getAllItems(){
        String sql = "SELECT * FROM Items";
        List<Items> allItems = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(Items.class));
        return allItems;
    }

    public void addItem(String itemName, int noOfItems, String supplierName, String contactNo, float price) {
        String sql = "INSERT INTO Items(itemName, noOfItems, supplierName, contactNo, price) values(?, ?, ?,?, ?)";

        jdbcTemplate.update(sql, itemName, noOfItems, supplierName, contactNo, price);
    }

    public void deleteItem(String itemName) {
        String sql = "DELETE from Items where itemName=?";
        jdbcTemplate.update(sql, itemName);
    }
}
