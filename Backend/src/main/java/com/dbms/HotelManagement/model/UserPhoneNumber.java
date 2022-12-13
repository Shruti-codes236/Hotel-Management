package com.dbms.HotelManagement.model;

import java.util.UUID;

public class UserPhoneNumber {
    private String phoneNumber;
    private UUID userID;

    public UserPhoneNumber() {
    }

    public UserPhoneNumber(String phoneNumber, UUID userID) {
        this.phoneNumber = phoneNumber;
        this.userID = userID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }
}
