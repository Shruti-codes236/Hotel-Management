package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.ContactUs;
import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.ContactUsService;
import com.dbms.HotelManagement.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactUsController {

    private final ContactUsService contactUsService;
    private final DashboardService dashboardService;

    @Autowired
    public ContactUsController(ContactUsService contactUsService, DashboardService dashboardService) {

        this.contactUsService = contactUsService;
        this.dashboardService = dashboardService;
    }

    @PostMapping("/contactus")
    public String contactus(@RequestBody ContactUs contactUs){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        UUID queryID = UUID.randomUUID();
        String name = contactUs.getName();
        String contactNumber = contactUs.getContactNumber();
        String reply = contactUs.getReply();
        String query = contactUs.getQuery();
        String emailID = contactUs.getEmailID();
        Calendar c = Calendar.getInstance();
        UUID customerID = cust.getCustomerID();
        contactUsService.addQuery(queryID,name,contactNumber,reply,query,emailID,customerID);
        return "Asked query";
    }

    @PostMapping("/contactus/repliedQuery")
    public List<ContactUs> repliedQuery(@RequestBody ContactUs contactUs) {
        System.out.println(contactUs.getCustomerID());
        return contactUsService.getRepliedQuery(contactUs.getCustomerID());
    }

    @PostMapping("/contactus/nullQuery")
    public List<ContactUs> nullQuery(@RequestBody ContactUs contactUs) {
        System.out.println(contactUs.getCustomerID());
        return contactUsService.getnullQuery(contactUs.getCustomerID());
    }
}
