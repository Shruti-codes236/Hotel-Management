package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public int registerUser(UUID userID, String fname, String lname, String pEmail, String pswd, String houseNo, String state, String city, String country, String pinCode, String gender) {
        String sql = "INSERT INTO User(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
//        System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
//        try {
            return jdbcTemplate.update(sql, userID.toString(), fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }

    public void deleteUser(UUID userID){
        String sql = "DELETE FROM User where userID = ?";

        jdbcTemplate.update(sql, userID.toString());
    }


    public User getUser(String pEmail) {
        String sql = "SELECT * FROM User WHERE pEmail = ?";
//        List<User> u=jdbcTemplate.query(sql,new Object[] {pEmail},UserMapper());
//        return u.get(0);
        User u=jdbcTemplate.queryForObject(sql,new Object[] {pEmail}, new BeanPropertyRowMapper<>(User.class));
        return u;
    }


    private RowMapper<User> UserMapper() {
        return (resultSet, i) -> {

            return new User(
                    UUID.fromString(resultSet.getString("userID")),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("pEmail"),
                    resultSet.getString("pswd"),
                    resultSet.getString("houseNo"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("country"),
                    resultSet.getString("pinCode"),
                    resultSet.getString("gender")
            );
        };
    }

    public void removeUser(String pEmail) {
        String sql = "DELETE FROM User WHERE pEmail = ?";
        jdbcTemplate.update(sql, pEmail);
    }

    public void updateUser(String fname, String lname, String pEmail, String houseNo, String state, String city, String country, String pinCode) {

        String sql = "UPDATE User SET fname = ?, lname = ?, houseNo = ?, state = ?, city = ?, country = ?, pinCode = ? where pEmail = ?";

        try {
            jdbcTemplate.update(sql, fname, lname, houseNo, state, city, country, pinCode, pEmail);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public boolean userExist(String pEmail) {
        String sql = "Select * from User where pEmail = ?";

        try{
            User u = jdbcTemplate.queryForObject(sql, new Object[]{pEmail}, new BeanPropertyRowMapper<>(User.class));
            System.out.println(u.getUserID());
            return true;
        }
        catch (Exception e){
            System.out.println(e);
//            System.out.println("Hwoels");
            return false;
        }
    }
}
