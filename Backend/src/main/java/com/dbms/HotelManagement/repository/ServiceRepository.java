package com.dbms.HotelManagement.repository;

import com.dbms.HotelManagement.jsonResponse.ServicesEmp;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.Service;
import com.dbms.HotelManagement.model.ServiceUsed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ServiceRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ServiceRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public int addService(String serviceName, boolean availability, float price, UUID headedBy) {
        String sql = "INSERT INTO Service(serviceName, availability, price, headedBy) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(sql, serviceName, availability, price, headedBy.toString());
    }

    public Service getServiceByName(String serviceName){
        String sql = "SELECT * FROM Service WHERE serviceName = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] { serviceName }, new BeanPropertyRowMapper<>(Service.class));

    }

    public List<ServicesEmp> getAllService(){
        String sql = "Select pEmail, price, availability, serviceName FROM Service, Employee as e, User as u where e.empID = headedBy and e.userID = u.userID";
        try{
           return jdbcTemplate.query(sql,new Object[]{}, ServicesEmpMapper());
        }
        catch ( Exception e){
            System.out.println(e);
            return new ArrayList<ServicesEmp>();
        }
    }

    public RowMapper<ServicesEmp> ServicesEmpMapper() {
        return (resultSet, i) -> {
            return new ServicesEmp(
                    resultSet.getString("serviceName"),
                    resultSet.getBoolean("availability"),
                    resultSet.getInt("price"),
                    resultSet.getString("pEmail")
            );
        };
    }

    public int updateAvailability(String serviceName, boolean availability){
        String sql = "UPDATE Service set availability = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, availability, serviceName);
    }

    public int updatePrice(String serviceName, int price){
        String sql = "UPDATE Service set price = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, price, serviceName);
    }

    public int updateHeadedBy(String serviceName, UUID headedBy){
        String sql = "UPDATE Service set headedBy = ? WHERE serviceName = ?";

        return jdbcTemplate.update(sql, headedBy.toString(), serviceName);
    }

    public int deleteService(String serviceName){
        String sql = "DELETE FROM Service WHERE serviceName = ?";
        return jdbcTemplate.update(sql);
    }


    public List<Service> serviceNames() {
        String sql = "SELECT * from Service where availability = true";

        return jdbcTemplate.query(sql, new Object[]{}, new BeanPropertyRowMapper<>(Service.class));
    }

    public void addusedService(String serviceName, UUID custID){
        String sql = "insert into ServiceUsed values (?,?)";
        jdbcTemplate.update(sql, serviceName, custID.toString());

    }

    public List<ServiceUsed> getBookingServices(UUID bookingID) {
        String sql = "SELECT * from ServiceUsed where bookingID = ?";
        
        return jdbcTemplate.query(sql, new Object[]{bookingID.toString()}, new BeanPropertyRowMapper<>(ServiceUsed.class));
        
    }

    public int serviceCost(UUID bookingID){
        String sql = "Select sum(price) from Service as s, ServiceUsed as su where su.bookingID=? and s.serviceName = su.serviceName";
        return jdbcTemplate.queryForObject(sql, new Object[]{bookingID.toString()}, Integer.class);
    }
}
