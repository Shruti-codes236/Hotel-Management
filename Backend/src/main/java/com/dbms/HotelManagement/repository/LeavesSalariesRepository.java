package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.model.LeavesSalaries;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.lang.ref.Cleaner;
import java.util.UUID;

@Repository
public class LeavesSalariesRepository {
    private final JdbcTemplate jdbcTemplate;

    public LeavesSalariesRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public LeavesSalaries getLeavesSalaries(UUID empID, int month, int year){
        String sql = "SELECT * FROM LeavesSalaries where empID = ? AND month = ? and year = ?";
        return jdbcTemplate.queryForObject(sql, new Object[] {empID.toString(), month, year}, new BeanPropertyRowMapper<>(LeavesSalaries.class));
    }

    public int addLeavesSalaries(UUID empID, int salaryPaid, int month, int year, int leavesAllowed, int leavesTaken){
        String sql = "INSERT INTO LeavesSalaries(salaryPaid, empID, month, year, leavesAllowed, leavesTaken) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, salaryPaid, empID.toString(), month, year, leavesAllowed, leavesTaken);
    }

    public int addLeave(UUID empID, int leavesTaken){
        String sql = "UPDATE LeavesSalaries set leavesTaken = ? WHERE empID = ?";
        return jdbcTemplate.update(sql, leavesTaken, empID.toString());
    }

    public int paySalary(UUID empID, int month, int year, int paidSalary){
        String sql = "UPDATE LeavesSalaries set salaryPaid = ? where empID = ? AND month = ? AND year = ?";
        return jdbcTemplate.update(sql, paidSalary, empID.toString(), month, year);

    }
}
