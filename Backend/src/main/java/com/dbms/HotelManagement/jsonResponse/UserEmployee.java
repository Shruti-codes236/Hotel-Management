package com.dbms.HotelManagement.jsonResponse;

import java.util.UUID;

public class UserEmployee {
    private UUID empID;
    private String houseNo;
    private String pincode;
    private String city;
    private String state;
    private String currHouseNo;
    private String currPincode;
    private String currCity;
    private String currState;
    private String phoneNo;
    private String maritalStatus;
    private String panCard;
    private String accountNo;
    private String IFSCCode;
    private String bankName;
    private UUID userID;
    private String deptName;
    private String superID;
    private String fname;
    private String lname;
    private String pEmail;
    private String pswd;
    private String country;
    private String gender;
    private int salary;
    private int leavesAllowed;


    public UserEmployee(UUID empID, String houseNo, String pincode, String city, String state, String currHouseNo, String currPincode, String currCity, String currState, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, String superID, String fname, String lname, String pEmail, String pswd, String country, String gender, int salary) {
        this.empID = empID;
        this.houseNo = houseNo;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.currHouseNo = currHouseNo;
        this.currPincode = currPincode;
        this.currCity = currCity;
        this.currState = currState;
        this.maritalStatus = maritalStatus;
        this.panCard = panCard;
        this.accountNo = accountNo;
        this.IFSCCode = IFSCCode;
        this.bankName = bankName;
        this.userID = userID;
        this.deptName = deptName;
        this.superID = superID;
        this.fname = fname;
        this.lname = lname;
        this.pEmail = pEmail;
        this.pswd = pswd;
        this.country = country;
        this.gender = gender;
        this.salary = salary;
    }

    public UserEmployee() {
    }

    public UserEmployee(UUID empID, String houseNo, String pincode, String city, String state, String currHouseNo, String currPincode, String currCity, String currState, String phoneNo, String maritalStatus, String panCard, String accountNo, String IFSCCode, String bankName, UUID userID, String deptName, String superID, String fname, String lname, String pEmail, String pswd, String country, String gender, int salary, int leavesAllowed) {
        this.empID = empID;
        this.houseNo = houseNo;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.currHouseNo = currHouseNo;
        this.currPincode = currPincode;
        this.currCity = currCity;
        this.currState = currState;
        this.phoneNo = phoneNo;
        this.maritalStatus = maritalStatus;
        this.panCard = panCard;
        this.accountNo = accountNo;
        this.IFSCCode = IFSCCode;
        this.bankName = bankName;
        this.userID = userID;
        this.deptName = deptName;
        this.superID = superID;
        this.fname = fname;
        this.lname = lname;
        this.pEmail = pEmail;
        this.pswd = pswd;
        this.country = country;
        this.gender = gender;
        this.salary = salary;
        this.leavesAllowed = leavesAllowed;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getLeavesAllowed() {
        return leavesAllowed;
    }

    public void setLeavesAllowed(int leavesAllowed) {
        this.leavesAllowed = leavesAllowed;
    }

    public UUID getEmpID() {
        return empID;
    }

    public void setEmpID(UUID empID) {
        this.empID = empID;
    }

    public String getHouseNo() {
        return houseNo;
    }

    public void setHouseNo(String houseNo) {
        this.houseNo = houseNo;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCurrHouseNo() {
        return currHouseNo;
    }

    public void setCurrHouseNo(String currHouseNo) {
        this.currHouseNo = currHouseNo;
    }

    public String getCurrPincode() {
        return currPincode;
    }

    public void setCurrPincode(String currPincode) {
        this.currPincode = currPincode;
    }

    public String getCurrCity() {
        return currCity;
    }

    public void setCurrCity(String currCity) {
        this.currCity = currCity;
    }

    public String getCurrState() {
        return currState;
    }

    public void setCurrState(String currState) {
        this.currState = currState;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPanCard() {
        return panCard;
    }

    public void setPanCard(String panCard) {
        this.panCard = panCard;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getIFSCCode() {
        return IFSCCode;
    }

    public void setIFSCCode(String IFSCCode) {
        this.IFSCCode = IFSCCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public UUID getUserID() {
        return userID;
    }

    public void setUserID(UUID userID) {
        this.userID = userID;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getSuperID() {
        return superID;
    }

    public void setSuperID(String superID) {
        this.superID = superID;
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

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}