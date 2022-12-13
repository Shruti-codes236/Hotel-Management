package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.jsonResponse.UserEmployee;
import com.dbms.HotelManagement.model.ContactUs;
import com.dbms.HotelManagement.model.Employee;
import com.dbms.HotelManagement.model.Feedback;
import com.dbms.HotelManagement.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AdminService {
    private final UserRepository userRepository;
    private final EmployeeRepository employeeRepository;
    private final FeedbackRepository feedbackRepository;
    private final ContactUsRepository contactUsRepository;
//    private final SalaryRepository salaryRepository;

    private final LeavesSalariesRepository leavesSalariesRepository;
    @Autowired
    public AdminService(UserRepository userRepository, EmployeeRepository employeeRepository, FeedbackRepository feedbackRepository, ContactUsRepository contactUsRepository, LeavesSalariesRepository salaryRepository) {
        this.userRepository = userRepository;
        this.employeeRepository = employeeRepository;
        this.feedbackRepository = feedbackRepository;
        this.contactUsRepository = contactUsRepository;
        this.leavesSalariesRepository = salaryRepository;
    }

    public void removeUser(String pEmail) {
        userRepository.removeUser(pEmail);
    }

    public void addEmployee(Employee employee){
//        UUID empID, String houseNo, String pincode, String city, String state, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, UUID superID
        employeeRepository.addEmployee(employee.getEmpID(), employee.getCurrHouseNo(), employee.getCurrPincode(), employee.getCurrCity(), employee.getCurrState(), employee.getMaritalStatus(), employee.getSalary(), employee.getPanCard(), employee.getAccountNo(), employee.getIFSCCode(), employee.getBankName(), employee.getUserID(), employee.getDeptName(), employee.getSuperID());
    }

    public List<UserEmployee> getEmployees() {
        return employeeRepository.getAllUserEmployee();
    }

    public List<Feedback> getFeedback() {
        System.out.println("reached");
        return feedbackRepository.getAllFeedback();
    }
//
    public List<ContactUs> getQuery() {
        return contactUsRepository.getAllQuery();
    }
//
    public ContactUs getQueryByID(UUID queryID) {
        return contactUsRepository.getQueryByID(queryID);
    }

    public void replyQuery(UUID queryID, String reply) {
        contactUsRepository.replyQuery(queryID, reply);
    }

    public void addSalary(int salaryPaid, UUID empID, int month, int year, int leavesAllowed, int leavesTaken) {
        leavesSalariesRepository.addLeavesSalaries(empID, salaryPaid, month, year, leavesAllowed, leavesTaken);
    }

//    public List<Employee> getCustomers() {
//        return employeeRepository.getAllCustomer();
//    }
}