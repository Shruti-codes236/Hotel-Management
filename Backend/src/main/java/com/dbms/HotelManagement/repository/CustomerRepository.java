package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CustomerRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerCustomer(UUID customerID, String alternateEmailAddress, String aadharCardNumber, UUID userID) {
        System.out.println(aadharCardNumber);
        String sql = "INSERT INTO Customer(customerID, alternateEmailAddress, aadharCardNumber, userID) VALUES (?,?,?,?)";
//        System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
//        try {
        return jdbcTemplate.update(sql, customerID.toString(), alternateEmailAddress, aadharCardNumber, userID.toString());
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public Customer getCustomer(String userID) {
        String sql = "SELECT * FROM Customer WHERE userID = ?";
//        List<User> u=jdbcTemplate.query(sql,new Object[] {pEmail},UserMapper());
//        return u.get(0);
        Customer c = jdbcTemplate.queryForObject(sql, new Object[]{userID}, new BeanPropertyRowMapper<>(Customer.class));
        return c;
    }

    public void updateCustomer(UUID userID, String aadharNo, String alterEmail) {
        System.out.println(userID + " " + aadharNo + " " +alterEmail);
        String sql = "UPDATE Customer SET aadharCardNumber = ?, alternateEmailAddress = ? where userID = ?";

        try {
            jdbcTemplate.update(sql, aadharNo, alterEmail, userID.toString());
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
}
