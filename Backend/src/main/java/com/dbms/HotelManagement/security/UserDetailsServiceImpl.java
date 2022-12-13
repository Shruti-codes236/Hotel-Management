package com.dbms.HotelManagement.security;

import com.dbms.HotelManagement.model.User;
import com.dbms.HotelManagement.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String pEmail) throws UsernameNotFoundException {
        try {
            User user = userRepository.getUser(pEmail);
            if(user != null){
                return new org.springframework.security.core.userdetails.User(user.getpEmail(), user.getPswd(), new ArrayList<>());
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        throw new UsernameNotFoundException("User not found");
    }
}
