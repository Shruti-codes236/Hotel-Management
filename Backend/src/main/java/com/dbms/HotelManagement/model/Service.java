package com.dbms.HotelManagement.model;

import java.util.UUID;

public class Service {
    private String serviceName;
    private boolean availability;
    private int price;
    private UUID headedBy;

    public Service() {
    }

    public Service(String serviceName, boolean availability, int price, UUID headedBy) {
        this.serviceName = serviceName;
        this.availability = availability;
        this.price = price;
        this.headedBy = headedBy;

    }

    public UUID getHeadedBy() {
        return headedBy;
    }
    public void setHeadedBy(UUID headedBy) {
        this.headedBy = headedBy;
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
}
