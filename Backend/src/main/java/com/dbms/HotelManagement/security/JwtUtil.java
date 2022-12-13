package com.dbms.HotelManagement.security;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {
    private final String SECRET_KEY = "USER_LOGIN";

    public String createToken(Authentication authentication){
        UserDetails user = (UserDetails) authentication.getPrincipal();
        int expirationTimeInMiliSeconds = 3 * 60 * 60 * 1000;
        return Jwts.builder().setSubject(user.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + expirationTimeInMiliSeconds))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String getEmailFromToken(String token){
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (Exception e){
            System.out.println(e);
        }
        return false;
    }
}
