package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.jsonResponse.UserCustomer;
import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RegisterController {
    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @Autowired

    public RegisterController(AuthenticationService authenticationService, PasswordEncoder passwordEncoder) {
        this.authenticationService = authenticationService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public String submitRegister(@RequestBody UserCustomer user) {
        UUID userID = UUID.randomUUID();
        String fname = user.getFname();
        String lname = user.getLname();
        String pEmail = user.getpEmail();
        String pswd = passwordEncoder.encode(user.getPswd());
        String houseNo = user.getHouseNo();
        String state = user.getState();
        String city = user.getCity();
        String country = user.getCountry();
        String pinCode = user.getPinCode();
        String gender = user.getGender();
        UUID customerID = UUID.randomUUID();
        String aadharNo = user.getAadharCardNumber();
        System.out.println(aadharNo);
        String alterEmail = user.getAlternateEmailAddress();
        System.out.println(aadharNo);
        if(authenticationService.userExist(pEmail)){
            System.out.println("HELLO ");
            return "fail";
//            ERROR;
        }
        else{
            authenticationService.register(userID, fname, lname, pEmail, pswd, houseNo, state, city, country, pinCode, gender);
            authenticationService.registerCustomer(customerID, alterEmail, aadharNo, userID);
            return fname + " " + lname + " " + pEmail + " " + pswd + " " + houseNo + " " + state + " " + city + " " + country + " " + pinCode + " " + gender;

        }
    }
}
