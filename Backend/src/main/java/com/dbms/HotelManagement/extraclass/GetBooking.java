package com.dbms.HotelManagement.extraclass;

import com.dbms.HotelManagement.model.Member;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class GetBooking {
    private UUID bookingID;
    private String checkInDate;
    private String checkOutDate;
    private int countMember;
    private int singleRoom;
    private int doubleRoom;
    private List<Member> membersList;
    private List<String> services;

    public GetBooking() {
    }

    public GetBooking(UUID bookingID, String checkInDate, String checkOutDate, int countMember, int singleRoom, int doubleRoom, List<Member> membersList, List<String> services) {
        this.bookingID = bookingID;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.countMember = countMember;
        this.singleRoom = singleRoom;
        this.doubleRoom = doubleRoom;
        this.membersList = membersList;
        this.services = services;
    }

    public List<String> getServices() {
        return services;
    }

    public void setServices(List<String> services) {
        this.services = services;
    }

    public UUID getBookingID() {
        return bookingID;
    }

    public void setBookingID(UUID bookingID) {
        this.bookingID = bookingID;
    }

    public String getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(String checkInDate) {
        this.checkInDate = checkInDate;
    }

    public String getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(String checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public int getCountMember() {
        return countMember;
    }

    public void setCountMember(int countMember) {
        this.countMember = countMember;
    }

    public int getSingleRoom() {
        return singleRoom;
    }

    public void setSingleRoom(int singleRoom) {
        this.singleRoom = singleRoom;
    }

    public int getDoubleRoom() {
        return doubleRoom;
    }

    public void setDoubleRoom(int doubleRoom) {
        this.doubleRoom = doubleRoom;
    }

    public List<Member> getMembersList() {
        return membersList;
    }

    public void setMembersList(List<Member> membersList) {
        this.membersList = membersList;
    }
}
