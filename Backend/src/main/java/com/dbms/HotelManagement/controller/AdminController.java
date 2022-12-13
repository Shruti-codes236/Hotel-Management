package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.SalaryPhoneNo;
import com.dbms.HotelManagement.jsonResponse.ServicesEmp;
import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.*;
import com.dbms.HotelManagement.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AdminController {
    private final AdminService adminService;
    private final ServiceService serviceService;
    private final AuthenticationService authenticationService;

    private final DashboardService dashboardService;
//    private final
    private final PasswordEncoder passwordEncoder;
    private final LeavesSalariesService leavesSalariesService;
    private final PhoneNoService phoneNoService;

    @Autowired
    public AdminController(AdminService adminService, ServiceService serviceService, AuthenticationService authenticationService, DashboardService dashboardService, PasswordEncoder passwordEncoder, LeavesSalariesService leavesSalariesService, PhoneNoService phoneNoService) {
        this.adminService = adminService;
        this.serviceService = serviceService;
        this.authenticationService = authenticationService;
        this.dashboardService = dashboardService;
        this.passwordEncoder = passwordEncoder;
        this.leavesSalariesService = leavesSalariesService;
        this.phoneNoService = phoneNoService;

    }

    // TODO make another model that would contain the attributes of both user and employee
    // TODO add on Delete cascade in sql user table

    @GetMapping("/admin/allEmployee")
    public List<UserEmployee> allEmployee(){
        List<UserEmployee> u = adminService.getEmployees();
        System.out.println(u.get(0).getSalary());

        return u;
    }


    @PostMapping("/admin/deleteEmployee")
    public String deleteEmployee(@RequestBody User user){
        String pEmail = user.getpEmail();
        adminService.removeUser(pEmail);
        return "deleted user with pEmail" + pEmail;
    }

    @PostMapping("/admin/addEmployee")
    public String addEmployee(@RequestBody UserEmployee userEmployee){
        System.out.println(userEmployee.getPincode());
        System.out.println(userEmployee.getCurrPincode());
        UUID userID = UUID.randomUUID();
        String fname = userEmployee.getFname();
        String lname = userEmployee.getLname();
        String pEmail = userEmployee.getpEmail();
        String pswd = passwordEncoder.encode(userEmployee.getPswd());
        String houseNo = userEmployee.getHouseNo();
        String state = userEmployee.getState();
        String city = userEmployee.getCity();
        String country = userEmployee.getCountry();
        String pinCode = userEmployee.getPincode();
        String gender = userEmployee.getGender();
        System.out.println(userID);
        authenticationService.register(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
        // Employee Details
        // UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID
        UUID empID = UUID.randomUUID();
        Employee employee = new Employee(
                empID,
                userEmployee.getCurrHouseNo(),
                userEmployee.getCurrPincode(),
                userEmployee.getCurrCity(),
                userEmployee.getCurrState(),
                userEmployee.getMaritalStatus(),
                userEmployee.getSalary(),
                userEmployee.getPanCard(),
                userEmployee.getAccountNo(),
                userEmployee.getIFSCCode(),
                userEmployee.getBankName(),
                userID,
                userEmployee.getDeptName(),
                UUID.fromString(userEmployee.getSuperID())
        );
        adminService.addEmployee(employee);

        // add leaves and salaries
        int salary = userEmployee.getSalary();
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);
        int leavesAllowed = userEmployee.getLeavesAllowed();
        int leavesTaken = 0;

        adminService.addSalary(-1, empID, month, year, leavesAllowed, leavesTaken);
        phoneNoService.addNo(userID, userEmployee.getPhoneNo());

        return "Added Employee";
    }


    @GetMapping("/admin/allFeedback")
    public List<Feedback> allFeedback(){
        return adminService.getFeedback();
    }

//    TODO UNCOMMENT
    @GetMapping("/admin/allQuery")
    public List<ContactUs> allQuery() {
        return adminService.getQuery();
    }

    @PostMapping("/admin/addReply")
    public String addReply(@RequestBody ContactUs contactUs){
        UUID queryID = contactUs.getQueryID();
        String reply = contactUs.getReply();
//        ContactUs query = adminService.getQueryByID(queryID);
        adminService.replyQuery(queryID,reply);
        return "Replied..";
    }

    @PostMapping("/admin/paySalary")
    public int paySalary(@RequestBody LeavesSalaries leavesSalaries){
        Employee emp= dashboardService.getEmpByEmpID(leavesSalaries.getEmpID());
        int sal = emp.getSalary();
        System.out.println(sal);
        if(leavesSalaries.getLeavesAllowed()<leavesSalaries.getLeavesTaken()){
            sal = 500*(leavesSalaries.getLeavesTaken()-leavesSalaries.getLeavesAllowed());
        }
        System.out.println(sal);
        return leavesSalariesService.paySalary(leavesSalaries.getEmpID(), leavesSalaries.getMonth(), leavesSalaries.getYear(), Math.max(sal, 0), leavesSalaries.getLeavesAllowed());
    }

    @PostMapping("/admin/getLeavesSalaries")
    public SalaryPhoneNo getLeavesSalaries(@RequestBody UserEmployee employee){
        UUID empID = employee.getEmpID();
        System.out.println(empID);
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;
        int year = c.get(Calendar.YEAR);

        LeavesSalaries l = leavesSalariesService.getLeavesSalaries(empID, month , year);
        SalaryPhoneNo salPhone = new SalaryPhoneNo(l.getSalaryPaid(), l.getEmpID(), l.getMonth(), l.getYear(), l.getLeavesAllowed(), l.getLeavesTaken());
        String s = phoneNoService.getPhoneNo(employee.getUserID());
        salPhone.setPhoneNo(s);
        System.out.println(salPhone.getSalaryPaid());
        return salPhone;
    }

    @PostMapping("/admin/addLeave")
    public LeavesSalaries addLeave(@RequestBody LeavesSalaries leavesSalaries){
        int i = leavesSalariesService.addLeave(leavesSalaries.getEmpID(), leavesSalaries.getLeavesTaken());
        leavesSalaries.setLeavesTaken(leavesSalaries.getLeavesTaken()+1);
        return leavesSalaries;
    }

    @PostMapping("/admin/getEmpByEmpID")
    public String getEmpByEmpID(@RequestBody Employee employee){
        Employee e = dashboardService.getEmpByEmpID(employee.getEmpID());
        User u = dashboardService.getDetails(e.getUserID().toString());
        return u.getpEmail();
    }


}