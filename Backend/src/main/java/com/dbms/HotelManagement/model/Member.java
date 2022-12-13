package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Member {
//    private UUID memberID;
    private String aadharNo;
    private int age;
    private String fname;
    private String lname;
    private UUID bookingID;

    public Member() {
    }

    public Member(String aadharNo, int age, String fname, String lname, UUID bookingID) {
        this.aadharNo = aadharNo;
        this.age = age;
        this.fname = fname;
        this.lname = lname;
        this.bookingID = bookingID;
    }

    public Member(String aadharNo, int age, String fname, String lname) {
        this.aadharNo = aadharNo;
        this.age = age;
        this.fname = fname;
        this.lname = lname;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
