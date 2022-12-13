package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.UserPhoneNumber;
import com.dbms.HotelManagement.repository.PhoneNoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PhoneNoService {

    private final PhoneNoRepository phoneNoRepository;

    @Autowired
    public PhoneNoService(PhoneNoRepository phoneNoRepository) { this.phoneNoRepository = phoneNoRepository; }

    public void addNo(UUID userID, String phoneNo) {
        List<String> phoneNos = List.of(phoneNo.split(","));
        for(int i = 0;i<phoneNos.size();i++){
            phoneNoRepository.addNo(userID, phoneNos.get(i));
        }
    }

    public String getPhoneNo(UUID userID){
        List<UserPhoneNumber> phoneNos = phoneNoRepository.getNo(userID);
        String s = "";
        for(int i =0;i<phoneNos.size();i++){
            s += phoneNos.get(i).getPhoneNumber();
            s += ", ";
        }
        return s;
    }
}
