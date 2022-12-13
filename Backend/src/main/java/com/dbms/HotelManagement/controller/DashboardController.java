package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.UserCustomer;
import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import com.dbms.HotelManagement.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DashboardController {
    private final DashboardService dashboardService;
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public DashboardController(DashboardService dashboardService, AuthenticationService authenticationService, PasswordEncoder passwordEncoder){
        this.dashboardService = dashboardService;
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/dashboard")
    public User dashboard(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
//        return pEmail;

        User user = dashboardService.getDetails(pEmail);
        Employee emp = dashboardService.getEmp(user.getUserID());
        System.out.println(emp.getUserID());
        System.out.println(emp);
        if(emp.getUserID() != null){
            user.setIsEmp(true);
        }
        return user;
    }


    @GetMapping("/dashboard/employee")
    public Employee employee(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Employee emp = dashboardService.getEmp(user.getUserID());
        return emp;
    }



    @GetMapping("/dashboard/customer")
    public Customer customer(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
//        cust = dashboardService.getCust(user.getUserID());
        return cust;
    }

    @GetMapping("/edit-profile")
    public UserCustomer userCust(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        System.out.println(pEmail);
        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        cust = dashboardService.getCust(user.getUserID());
        UserCustomer uc=new UserCustomer();
        uc.setUserID(user.getUserID());
        uc.setFname(user.getFname());
        uc.setLname(user.getLname());
        uc.setpEmail(user.getpEmail());
        uc.setPswd(user.getPswd());
        uc.setHouseNo(user.getHouseNo());
        uc.setState(user.getState());
        uc.setCity(user.getCity());
        uc.setCountry(user.getCountry());
        uc.setPinCode(user.getPinCode());
        uc.setGender(user.getGender());
        uc.setCustomerID(cust.getCustomerID());
        uc.setAlternateEmailAddress(cust.getAlternateEmailAddress());
        uc.setAadharCardNumber(cust.getAadharCardNumber());

        return uc;


    }

    @PostMapping("/edit-profile")
    public String editProfile(@RequestBody UserCustomer user){

        String fname = user.getFname();
        String lname = user.getLname();
        String pEmail = user.getpEmail();
        String houseNo = user.getHouseNo();
        String state = user.getState();
        String city = user.getCity();
        String country = user.getCountry();
        String pinCode = user.getPinCode();
        String aadharNo = user.getAadharCardNumber();
        String alterEmail = user.getAlternateEmailAddress();
        User userNew = dashboardService.getDetails(pEmail);

        System.out.println(alterEmail);
        System.out.println(userNew.getUserID());

        dashboardService.updateUser(fname, lname, pEmail, houseNo, state, city, country, pinCode);
        dashboardService.updateCustomer(userNew.getUserID(), aadharNo, alterEmail);

        return "Profile Update";
    }
}


