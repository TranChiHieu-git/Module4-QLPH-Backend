package com.codegym.meeting_room_management.webservice.controller.userController;

import com.codegym.meeting_room_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class userController {
    @Autowired
    private UserService userService;
}
