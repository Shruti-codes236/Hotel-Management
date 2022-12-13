package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.extraclass.GetBooking;
import com.dbms.HotelManagement.extraclass.TempBooking1;
import com.dbms.HotelManagement.jsonResponse.GenerateBill;
import com.dbms.HotelManagement.jsonResponse.IntPrice;
import com.dbms.HotelManagement.model.*;
import com.dbms.HotelManagement.service.*;
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
public class BookingController {

    private final BookingService bookingService;
    private final MemberService memberService;
    private final BillService billService;
    private final DashboardService dashboardService;
    private final ServiceService serviceService;

    @Autowired
    public BookingController(BookingService bookingService, MemberService memberService, BillService billService, DashboardService dashboardService, ServiceService serviceService) {
        this.bookingService = bookingService;
        this.memberService = memberService;
        this.billService = billService;
        this.dashboardService = dashboardService;
        this.serviceService = serviceService;
    }

    @PostMapping("/booking/check")
    public boolean checkAvail(@RequestBody TempBooking1 booking){
        System.out.println("reached");
        boolean isBooking = bookingService.getAvail(booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
//        if(isBooking){
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            UserDetails obj = (UserDetails) auth.getPrincipal();
//            String pEmail = obj.getUsername();
//            User user = dashboardService.getDetails(pEmail);
//            Customer cust = dashboardService.getCust(user.getUserID());
//            bookingService.book(cust.getCustomerID(), booking.getCheckIn(), booking.getCheckOut(), booking.getSingleOcc(), booking.getDoubleOcc());
//        }
        return isBooking;


    }
    @PostMapping("/booking/book")
    public GenerateBill bookRoom(@RequestBody GetBooking booking) {
//        System.out.println(booking.getMembersList());
        System.out.println(booking.getServices());
        System.out.println(booking.getMembersList().get(0).getAadharNo());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();
        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        UUID customerID = cust.getCustomerID();
        String checkInDate = booking.getCheckInDate();
        String checkOutDate = booking.getCheckOutDate();
        System.out.println(checkInDate);
        System.out.println(booking.getSingleRoom());
        UUID bookingID = UUID.randomUUID();
        IntPrice p = bookingService.book(bookingID, customerID, checkInDate, checkOutDate, booking.getSingleRoom(), booking.getDoubleRoom());
        int r = memberService.addMember(bookingID, booking.getCountMember(), booking.getMembersList());

        serviceService.addusedService(booking.getServices(), bookingID);
        UUID billID = UUID.randomUUID();
        int singlePrice = p.getSinglePrice();
        int doublePrice = p.getDoublePrice();
        int servicePrice = serviceService.getPrice(bookingID);
        int amount = singlePrice*booking.getSingleRoom() + doublePrice*booking.getDoubleRoom() + servicePrice;
        GenerateBill generateBill = new GenerateBill(billID, bookingID, amount, booking.getSingleRoom(), booking.getDoubleRoom(), singlePrice, doublePrice, user.getFname(), user.getLname(), servicePrice);
        System.out.println(amount);
//        Bill bill = new Bill(billID, bookingID, amount,)
        LocalDate date = LocalDate.now(ZoneId.of("Asia/Kolkata"));
        LocalTime time = LocalTime.now(ZoneId.of("Asia/Kolkata"));
        billService.addBill(billID, bookingID, amount, date, time);
        return generateBill;
    }

    @GetMapping("/customer/booking")
    public List<GetBooking> getCustBooking(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails obj = (UserDetails) auth.getPrincipal();
        String pEmail = obj.getUsername();

        User user = dashboardService.getDetails(pEmail);
        Customer cust = dashboardService.getCust(user.getUserID());
        List<GetBooking> b =  bookingService.getBookings(cust.getCustomerID());
        System.out.println(b.size() + " " + b.get(0).getCheckOutDate() + " " + b.get(0).getCountMember());
        return b;
    }




}
