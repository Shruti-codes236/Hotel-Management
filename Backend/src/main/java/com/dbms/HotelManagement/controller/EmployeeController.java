package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import com.dbms.HotelManagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final DashboardService dashboardService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder, DashboardService dashboardService) {
        this.employeeService = employeeService;
        this.dashboardService = dashboardService;
    }

    @GetMapping("/Employee/allEmployee")
    public List<Employee> allEmployee(){
        return employeeService.getEmployees();
    }

    @GetMapping("/dashboard/employee/subord")
    public List<UserEmployee> getSubord(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Employee emp = dashboardService.getEmp(user.getUserID());
        return employeeService.getSubord(emp.getEmpID());
    }


}
