package com.dbms.HotelManagement.model;

import java.util.UUID;

public class ServiceUsed {
    private String serviceName;
    private UUID bookingID;

    public ServiceUsed(String serviceName, UUID bookingID) {
        this.serviceName = serviceName;
        this.bookingID = bookingID;
    }

    public ServiceUsed() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }
}
