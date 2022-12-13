package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.extraclass.frontFeedback;
import com.dbms.HotelManagement.model.Customer;
import com.dbms.HotelManagement.model.Feedback;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.DashboardService;
import com.dbms.HotelManagement.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class FeedbackController {

    private final FeedbackService feedbackService;
    private final DashboardService dashboardService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService, DashboardService dashboardService) {
        this.feedbackService = feedbackService;
        this.dashboardService = dashboardService;
    }


    @PostMapping("/feedback")
    public String feedback(@RequestBody frontFeedback frontFeedback){
        UUID feedbackID =UUID.randomUUID();
        String reviews = frontFeedback.getReviews();
        String suggestions = frontFeedback.getSuggestions();
        //current date time has to be obtained
        LocalDate date = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
//        String date = "2022-10-1";
//        String time = "05:46:50";
//        String date = feedback.getDate();
//        String time = feedback.getTime();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        String bookingID = frontFeedback.getBookingID();
        System.out.println(bookingID);

        feedbackService.addFeedback(feedbackID, reviews, suggestions,date,time,UUID.fromString(bookingID));
        System.out.println(date);
        System.out.println(time);
        return "Given Feedback";
    }


}