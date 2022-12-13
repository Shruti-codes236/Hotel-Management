package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.extraclass.GetBooking;
import com.dbms.HotelManagement.jsonResponse.IntPrice;
import com.dbms.HotelManagement.model.Booking;
import com.dbms.HotelManagement.model.Member;
import com.dbms.HotelManagement.model.Room;
import com.dbms.HotelManagement.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public boolean getAvail(String checkIn, String checkOut, int singleOcc, int doubleOcc){
        int singleAvail = bookingRepository.getSingle(checkIn, checkOut);
        int doubleAvail = bookingRepository.getDouble(checkIn, checkOut);
        return (singleAvail >= singleOcc && doubleAvail >= doubleOcc);
    }

    public IntPrice book(UUID bookingID, UUID customerID, String checkInDate, String checkOutDate, int singleRoom, int doubleRoom){
        try {
            IntPrice price = new IntPrice();
            List<Room> singleAvailRoom = bookingRepository.getRoomSingle(checkInDate, checkOutDate);
            List<Room> doubleAvailRoom = bookingRepository.getRoomDouble(checkInDate, checkOutDate);
            price.setSinglePrice((int)singleAvailRoom.get(0).getPrice());
            price.setDoublePrice((int)doubleAvailRoom.get(0).getPrice());
            bookingRepository.book(bookingID, checkInDate, checkOutDate, customerID);
            for(int i=0;i<singleRoom;i++){
                bookingRepository.bookRoom(bookingID, singleAvailRoom.get(i).getRoomNo());

            }
            for(int i=0;i<doubleRoom;i++) {
                bookingRepository.bookRoom(bookingID, doubleAvailRoom.get(i).getRoomNo());
            }
            return price;
//            System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
        } catch (Exception e) {
            System.out.println(e);
        }
        return new IntPrice();
//        return new UUID( 0 , 0 );
    }

    public List<GetBooking> getBookings(UUID custID){
        return bookingRepository.getGetBooking(custID);

    }



}
