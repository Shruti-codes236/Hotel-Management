package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Bill {
    private UUID billID;
    private UUID bookingID;
    private int amount;
    private String bDate;
    private String bTime;

    public Bill(UUID billID, UUID bookingID, int amount, String date, String time) {
        this.billID = billID;
        this.bookingID = bookingID;
        this.amount = amount;
        this.bDate = date;
        this.bTime = time;
    }

    public Bill() {
    }

    public UUID getBillID() {
        return billID;
    }

    public void setBillID(UUID billID) {
        this.billID = billID;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public String getbTime() {
        return bTime;
    }

    public void setbTime(String bTime) {
        this.bTime = bTime;
    }
}
