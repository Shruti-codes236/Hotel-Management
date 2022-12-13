package com.dbms.HotelManagement.model;

public class Items {
    private String itemName;
    private int noOfItems;
    private float price;
    private String contactNo;
    private String SupplierName;

    public int getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(int noOfItems) {
        this.noOfItems = noOfItems;
    }

    public Items(String itemName, int noOfItems, float price, String contactNo, String supplierName) {
        this.itemName = itemName;
        this.noOfItems = noOfItems;
        this.price = price;
        this.contactNo = contactNo;
        SupplierName = supplierName;
    }

    public Items() {

    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getSupplierName() {
        return SupplierName;
    }

    public void setSupplierName(String supplierName) {
        SupplierName = supplierName;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
