package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class EmployeeRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeRepository(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

//    public int registerEmployee(UUID empID, String currHouseNo, String currPincode, String currCity, String currState, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID){
//        String sql = "INSERT INTO Employee(empID, currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
//        return jdbcTemplate.update(sql, empID.toString(), currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID);
//    }
    public Employee getEmployee(String userID){
        String sql = "Select * from Employee where userID = ?";
        try{

            return jdbcTemplate.queryForObject(sql, new Object[]{userID}, new BeanPropertyRowMapper<>(Employee.class));
        }
        catch (Exception e){
            System.out.println(e);
            return new Employee();
        }
    }

    public Employee getEmployeeByEmpID(String empID){
        String sql = "Select * from Employee where empID = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{empID}, new BeanPropertyRowMapper<>(Employee.class));
    }

    public List<Employee> getAllEmployee() {
        String sql = "SELECT * FROM Employee";
        List<Employee> e = jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper(Employee.class));
        return e;
    }

    public void addEmployee(UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, int salary, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID){
        String sql = "INSERT INTO Employee(empID, currHouseNo, currPincode, currCity, currState, maritalStatus, salary, panCard, accountNo, IFSCCode, bankName, userID, deptName, superID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, empID.toString(), houseNo, pincode, city, state, maritalStatus, salary, panCard, accountNo, IFSCCode, bankName, userID.toString(), deptName, superID.toString());
    }

    public List<UserEmployee> getSubord( UUID empID)
    {
        String sql="SELECT * FROM Employee as e, User as u WHERE superID=? AND u.userID = e.userID";
        List<UserEmployee> u= jdbcTemplate.query(sql, new Object[]{empID.toString()}, UserEmployeeMapper());
        System.out.println(u.get(0).getSalary());
        return u;
    }

    private RowMapper<Employee> EmployeeMapper() {
        return (resultSet, i) -> {
            return new Employee(
                    UUID.fromString(resultSet.getString("empID")),
                    resultSet.getString("currHouseNo"),
                    resultSet.getString("currPincode"),
                    resultSet.getString("currCity"),
                    resultSet.getString("currState"),
                    resultSet.getString("maritalStatus"),
                    resultSet.getInt("salary"),
                    resultSet.getString("panCard"),
                    resultSet.getString("accountNo"),
                    resultSet.getString("IFSCCode"),
                    resultSet.getString("bankName"),
                    UUID.fromString(resultSet.getString("userID")),
                    resultSet.getString("deptName"),
                    UUID.fromString(resultSet.getString("superID"))
            );
        };
    }

    public List<UserEmployee> getAllUserEmployee() {
        String sql = "SELECT empID, houseNo, pincode, city, state, currHouseNo, currPincode, currCity, currState, maritalStatus, panCard, accountNo, IFSCCode, bankName, e.userID, deptName, superID, fname,lname, pEmail, pswd, country, gender, salary from Employee as e, User as u where u.userID = e.userID";

        return jdbcTemplate.query(sql, new Object[]{}, UserEmployeeMapper());
    }

    private RowMapper<UserEmployee> UserEmployeeMapper() {
        return (resultSet, i) -> {
            System.out.println(resultSet.getInt("salary"));
            return new UserEmployee(
                    UUID.fromString(resultSet.getString("empID")),
                    resultSet.getString("houseNo"),
                    resultSet.getString("pincode"),
                    resultSet.getString("city"),
                    resultSet.getString("state"),
                    resultSet.getString("currHouseNo"),
                    resultSet.getString("currPincode"),
                    resultSet.getString("currCity"),
                    resultSet.getString("currState"),
                    resultSet.getString("maritalStatus"),
                    resultSet.getString("panCard"),
                    resultSet.getString("accountNo"),
                    resultSet.getString("IFSCCode"),
                    resultSet.getString("bankName"),
                    UUID.fromString(resultSet.getString("userID")),
                    resultSet.getString("deptName"),
                    resultSet.getString("superID"),
                    resultSet.getString("fname"),
                    resultSet.getString("lname"),
                    resultSet.getString("pEmail"),
                    resultSet.getString("pswd"),
                    resultSet.getString("country"),
                    resultSet.getString("gender"),
                    resultSet.getInt("salary")
            );
        };
    }
}