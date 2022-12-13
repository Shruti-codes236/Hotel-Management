package com.dbms.HotelManagement.jsonResponse;

import java.util.UUID;

public class ServicesEmp {
    private String serviceName;
    private boolean availability;
    private int price;
    private String headedBy;

    public ServicesEmp(String serviceName, boolean availability, int price, String headedBy) {
        this.serviceName = serviceName;
        this.availability = availability;
        this.price = price;
        this.headedBy = headedBy;
    }

    public ServicesEmp() {
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHeadedBy() {
        return headedBy;
    }

    public void setHeadedBy(String headedBy) {
        this.headedBy = headedBy;
    }
}
