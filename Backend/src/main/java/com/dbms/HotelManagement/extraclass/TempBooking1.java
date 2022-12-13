package com.dbms.HotelManagement.extraclass;


public class TempBooking1 {
    private String checkIn;
    private String checkOut;
    private int singleOcc;
    private int doubleOcc;
    private int noOfMembers;

    public TempBooking1() {
    }

    public TempBooking1(String checkIn, String checkOut, int singleOcc, int doubleOcc, int noOfMembers) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.singleOcc = singleOcc;
        this.doubleOcc = doubleOcc;
        this.noOfMembers = noOfMembers;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getSingleOcc() {
        return singleOcc;
    }

    public void setSingleOcc(int singleOcc) {
        this.singleOcc = singleOcc;
    }

    public int getDoubleOcc() {
        return doubleOcc;
    }

    public void setDoubleOcc(int doubleOcc) {
        this.doubleOcc = doubleOcc;
    }

    public int getNoOfMembers() {
        return noOfMembers;
    }

    public void setNoOfMembers(int noOfMembers) {
        this.noOfMembers = noOfMembers;
    }
}
