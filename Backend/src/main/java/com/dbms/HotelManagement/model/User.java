package com.dbms.HotelManagement.model;

import java.util.UUID;

public class User {
    private UUID userID;
    private String fname;
    private String lname;
    private String pEmail;
    private String pswd;
    private String houseNo;
    private String state;
    private String city;
    private String country;
    private String pinCode;
    private String gender;
    private boolean isEmp;
    public  User(){}

    public User(UUID userID, String fname, String lname, String pEmail, String pswd, String houseNo, String state, String city, String country, String pinCode, String gender) {
        this.userID = userID;
        this.fname = fname;
        this.lname = lname;
        this.pEmail = pEmail;
        this.pswd = pswd;
        this.houseNo = houseNo;
        this.state = state;
        this.city = city;
        this.country = country;
        this.pinCode = pinCode;
        this.gender = gender;
    }


    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
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

    public String getpEmail() {
        return pEmail;
    }

    public void setpEmail(String pEmail) {
        this.pEmail = pEmail;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public boolean getIsEmp() {
        return isEmp;
    }

    public void setIsEmp(boolean emp) {
        isEmp = emp;
    }
}
