package com.dbms.HotelManagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LogOutController {
    @GetMapping("/logout_")
    public String userLogout(){
        SecurityContextHolder.getContext().setAuthentication(null);
        return "logout";
    }
}
