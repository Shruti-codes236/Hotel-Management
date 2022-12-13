package com.dbms.HotelManagement.model;

import java.util.UUID;

public class LeavesSalaries {
    private int salaryPaid;
    private UUID empID;
    private int month;
    private int year;
    private int leavesAllowed;
    private int leavesTaken;

    public LeavesSalaries(int salaryPaid, UUID empID, int month, int year, int leavesAllowed, int leavesTaken) {
        this.salaryPaid = salaryPaid;
        this.empID = empID;
        this.month = month;
        this.year = year;
        this.leavesAllowed = leavesAllowed;
        this.leavesTaken = leavesTaken;
    }

    public LeavesSalaries() {
    }

    public int getSalaryPaid() {
        return salaryPaid;
    }

    public void setSalaryPaid(int salaryPaid) {
        this.salaryPaid = salaryPaid;
    }

    public UUID getEmpID() {
        return empID;
    }

    public void setEmpID(UUID empID) {
        this.empID = empID;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLeavesAllowed() {
        return leavesAllowed;
    }

    public void setLeavesAllowed(int leavesAllowed) {
        this.leavesAllowed = leavesAllowed;
    }

    public int getLeavesTaken() {
        return leavesTaken;
    }

    public void setLeavesTaken(int leavesTaken) {
        this.leavesTaken = leavesTaken;
    }
}