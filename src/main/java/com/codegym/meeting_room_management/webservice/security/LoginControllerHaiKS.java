package com.codegym.meeting_room_management.webservice.security;

import com.codegym.meeting_room_management.dao.DTO.AccountDTO;
import com.codegym.meeting_room_management.dao.DTO.JwtResponse;
import com.codegym.meeting_room_management.service.impl.UserServiceHaiKSImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")
public class LoginControllerHaiKS {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserServiceHaiKSImpl userServiceHaiKSImpl;

    @PostMapping("/")
    public ResponseEntity<?> login(@RequestBody AccountDTO accountDTO) {
        System.out.println(accountDTO.getAccountName());
        System.out.println(accountDTO.getAccountPassword());
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(accountDTO.getAccountName(), accountDTO.getAccountPassword())
        );
        UserDetails userDetails = userServiceHaiKSImpl.loadUserByUsername(authentication.getName());
        String jwtToken = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwtToken, userDetails.getUsername(), userDetails.getAuthorities()));
    }
}
