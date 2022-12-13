package com.dbms.HotelManagement.security;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;

@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtFilter(JwtUtil jwtUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        System.out.println(request.getHeaderNames());
        response.setHeader("Access-Control-Allow-Origin","http://localhost:3000");
        response.setHeader("Access-Control-Allow-Headers", "*");
//        response.setHeader("Access-Control-Expose-Headers","*");
        response.setHeader("Access-Control-Allow-Credentials","true");
            try {
                System.out.println(request);
                String jwtToken = request.getHeader(AUTHORIZATION);
                System.out.println(jwtToken);
                String token = null;

                if (StringUtils.hasText(jwtToken) && jwtToken.startsWith("Bearer ")) {
                    token = jwtToken.substring(7, jwtToken.length());
                }

                if (token != null && jwtUtil.validateToken(token)) {
                    String pEmail = jwtUtil.getEmailFromToken(token);
                    if (pEmail != null) {
                        UserDetails userDetails = userDetailsService.loadUserByUsername(pEmail);

                        UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                        auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                        SecurityContextHolder.getContext().setAuthentication(auth);
                    }
                }
            } catch (Exception e) {
                System.out.println(e);
            }

        filterChain.doFilter(request,response);
    }
}
