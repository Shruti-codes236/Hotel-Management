package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Room {
    private int roomNo;
    private String type;
    private float price;
//    private String status;
    private int floor;
//    private String checkInDate;
//    private String checkOutDate;
//    private UUID customerID;


    public Room(int roomNo, String type, float price, int floor) {
        this.roomNo = roomNo;
        this.type = type;
        this.price = price;
        this.floor = floor;
    }

    public Room() {
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

//    public String getCheckInDate() {
//        return checkInDate;
//    }
//
//    public void setCheckInDate(String checkInDate) {
//        this.checkInDate = checkInDate;
//    }

//    public String getCheckOutDate() {
//        return checkOutDate;
//    }
//
//    public void setCheckOutDate(String checkOutDate) {
//        this.checkOutDate = checkOutDate;
//    }

//    public UUID getCustomerID() {
//        return customerID;
//    }
//
//    public void setCustomerID(UUID customerID) {
//        this.customerID = customerID;
//    }
}
