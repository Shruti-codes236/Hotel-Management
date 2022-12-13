package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.Bill;
import com.dbms.HotelManagement.repository.BillRepository;
import org.springframework.stereotype.Service;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.UUID;

@Service
public class BillService {

    private final BillRepository billRepository;


    public BillService(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    public Bill getBill(UUID bookingID){
        return billRepository.getBill(bookingID);
    }

    public void addBill(UUID billID, UUID bookingID, int amount, LocalDate bDate, LocalTime bTime){
        billRepository.addBill(billID, bookingID, amount, bDate, bTime);

    }
}
