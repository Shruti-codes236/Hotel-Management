package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Booking {

    private UUID bookingID;
    private UUID customerID;
//    private int singleRooms; store as temporary json object for running sql query to search for available rooms
    //if available customer will be asked to confirm booking
        //available rooms will be selected as per customer requirement and stored in another table(aka booking-room)
    //else display not available

//    private int doubleRooms;
//    private int roomNo; separate table containing booking id and room nos as room no is a multi valued attribute here(booking-room)
    private String checkInDate;
    private String checkOutDate;



    public Booking() {
    }

    public Booking(UUID bookingID, UUID customerID, String checkInDate, String checkOutDate) {
        this.bookingID = bookingID;
        this.customerID = customerID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }

//    public int getRoomNo() {
//        return roomNo;
//    }
//
//    public void setRoomNo(int roomNo) {
//        this.roomNo = roomNo;
//    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

//    public int getSingleRooms() {
//        return singleRooms;
//    }
//
//    public void setSingleRooms(int singleRooms) {
//        this.singleRooms = singleRooms;
//    }
//
//    public int getDoubleRooms() {
//        return doubleRooms;
//    }
//
//    public void setDoubleRooms(int doubleRooms) {
//        this.doubleRooms = doubleRooms;
}



