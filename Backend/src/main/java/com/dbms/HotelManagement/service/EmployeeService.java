package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployees() {
        return employeeRepository.getAllEmployee();
    }

    public List<UserEmployee> getSubord(UUID empID) {
        return employeeRepository.getSubord(empID);
    }
}
