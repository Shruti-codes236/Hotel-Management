package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.repository.CustomerRepository;
import com.dbms.HotelManagement.repository.EmployeeRepository;
import com.dbms.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class DashboardService {
    private final UserRepository userRepository;
    private final EmployeeRepository empRepository;
    private final CustomerRepository custRepository;

    @Autowired
    public DashboardService(UserRepository userRepository, EmployeeRepository empRepository, CustomerRepository custRepository){

        this.userRepository = userRepository;
        this.empRepository = empRepository;
        this.custRepository = custRepository;
    }

    public User getDetails(String pEmail){
        User user = userRepository.getUser(pEmail);
        return user;
    }

    public Employee getEmp(UUID userID){
        Employee emp = empRepository.getEmployee(userID.toString());
        return emp;
    }


    public Customer getCust(UUID userID) {
        Customer cust = custRepository.getCustomer(userID.toString());
        return cust;
    }

    public void updateUser(String fname, String lname, String pEmail, String houseNo, String state, String city, String country, String pinCode) {
        userRepository.updateUser(fname, lname, pEmail, houseNo, state, city, country, pinCode);
    }

    public void updateCustomer(UUID userID, String aadharNo, String alterEmail) {
        custRepository.updateCustomer(userID, aadharNo, alterEmail);
    }

    public Employee getEmpByEmpID(UUID empID) {
        return empRepository.getEmployeeByEmpID(empID.toString());
    }
}
