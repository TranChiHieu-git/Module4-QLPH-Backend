package com.codegym.meeting_room_management.webservice.controller.userController;

import com.codegym.meeting_room_management.dao.entity.User;
import com.codegym.meeting_room_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
@RequestMapping("")public class UserController {
    @Autowired
    private UserService userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    //--------------------- create account --------------------------------------------------
//    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
//    public ResponseEntity<Void> createAccount(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
//        User user1 = userService.findUserByUserName(user.getUsername());
//        if (user1 != null) {
//            throw new UsernameNotFoundException("Tên đăng nhập đã tồn tại");
//        } else {
//            user.setPassword((passwordEncoder.encode(account.getAccountPassword())));
//            accountService.save(account);
//            HttpHeaders headers = new HttpHeaders();
//            headers.setLocation(uriComponentsBuilder.path("account?page=0&size=5&search=").buildAndExpand(account.getAccountId()).toUri());
//            return new ResponseEntity<>(headers, HttpStatus.CREATED);
//        }
//    }
}
