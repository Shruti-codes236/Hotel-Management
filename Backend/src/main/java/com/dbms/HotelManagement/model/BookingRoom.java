package com.dbms.HotelManagement.model;

import java.util.UUID;

public class BookingRoom {
    private UUID bookingID;
    private int roomNo;

    public BookingRoom(UUID bookingID, int roomNo) {
        this.bookingID = bookingID;
        this.roomNo = roomNo;
    }

    public BookingRoom() {
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }
}

