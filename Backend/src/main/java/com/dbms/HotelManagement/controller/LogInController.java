package com.dbms.HotelManagement.controller;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.security.JwtUtil;
import com.dbms.HotelManagement.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class LogInController {

    private final AuthenticationManager authenticationManager;
    private final AuthenticationService authenticationService;

    private final JwtUtil jwtUtil;

    @Autowired
    public LogInController(AuthenticationManager authenticationManager, AuthenticationService authenticationService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.authenticationService = authenticationService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity customerLogIn(@RequestBody User user){
        String pEmail = user.getpEmail();
        String pswd = user.getPswd();
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(pEmail, pswd));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtil.createToken(authentication);
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication(); // if null then noone logged in
//            System.out.println("Login : " + auth);
//            UserDetails obj = (UserDetails) auth.getPrincipal(); // isse username (in this case pEmail) mil jayega tumeh
//            String pEmail = obj.getUsername();
        Map<String,String> jsonResponse = new HashMap<>();
        jsonResponse.put("token",token);
        return ResponseEntity.ok(jsonResponse);
    }
}