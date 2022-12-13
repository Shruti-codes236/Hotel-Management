package com.dbms.HotelManagement.model;

import java.util.UUID;

public class ContactUs {
    private UUID queryID;
    private String name;
    private String contactNumber;
    private String reply;
    private String query;
    private String emailID;
    private String date;
    private String time;
    private UUID customerID;

    public ContactUs() {
    }

    public ContactUs(UUID queryID, String name, String contactNumber, String reply, String query, String emailID, String date, String time, UUID customerID) {
        this.queryID = queryID;
        this.name = name;
        this.contactNumber = contactNumber;
        this.reply = reply;
        this.query = query;
        this.emailID = emailID;
        this.date = date;
        this.time = time;
        this.customerID = customerID;
    }

    public UUID getQueryID() {
        return queryID;
    }

    public void setQueryID(UUID queryID) {
        this.queryID = queryID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getReply() {
        return reply;
    }

    public void setReply(String reply) {
        this.reply = reply;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public UUID getCustomerID() {
        return customerID;
    }

    public void setCustomerID(UUID customerID) {
        this.customerID = customerID;
    }
}
