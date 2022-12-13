package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.repository.CustomerRepository;
import com.dbms.HotelManagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AuthenticationService {
    private final UserRepository userRepository;
    private final CustomerRepository customerRepository;
        private String SESSION_KEY = "USER_SESSION";
//    private final String SESSION_KEY = "USER_SESSION";

    @Autowired
    public AuthenticationService(UserRepository userRepository, CustomerRepository customerRepository) {
        this.userRepository = userRepository;
        this.customerRepository = customerRepository;
    }

    public void register(UUID userID, String fname, String lname, String pEmail, String pswd, String houseNo, String state, String city, String country, String pinCode, String gender) {
        try {
            System.out.println(userID.toString());
            userRepository.registerUser(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
//            System.out.println(userID + " " + fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void registerCustomer(UUID customerID, String alterEmail, String aadharNo, UUID userID) {
        try{
            customerRepository.registerCustomer(customerID, alterEmail, aadharNo, userID);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public Boolean checkUserCredentials(String pEmail, String password) {
        User user = userRepository.getUser(pEmail);
        return user.getPswd().equals(password);
    }

    public User getUserByEmail(String pEmail){
        User user = userRepository.getUser(pEmail);
        return user;
    }

    public boolean userExist(String pEmail) {
        return userRepository.userExist(pEmail);
    }
}