package com.codegym.meeting_room_management.webservice.controller;

import com.codegym.meeting_room_management.dao.entity.*;
import com.codegym.meeting_room_management.dao.repository.AdminNotificationRepository;
import com.codegym.meeting_room_management.service.NotificationService;
import com.codegym.meeting_room_management.service.RoomService;
import com.codegym.meeting_room_management.service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class NoticationController {
    @Autowired
    UserNotificationService userNotificationService;
    @Autowired
    AdminNotificationRepository adminNotiRepo;
    @Autowired
    NotificationService notificationService;
    @Autowired
    RoomService roomService;

    @GetMapping("/user/notification/{id}")
    public List<UserNotification> getAllByUserId(@PathVariable int id) {
        return userNotificationService.getAllByUserId(id);
    }
    @PostMapping("/user/notification/save")
    public ResponseEntity<String> saveNotification(@RequestBody Notification notification){
        System.out.println(notification.getRoom().getId());
        this.notificationService.save(notification);
        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/admin/notification/all")
    public List<AdminNotification> getAll() {
        return adminNotiRepo.findAll();
    }
    @GetMapping("/user/room/all")
    public ResponseEntity<List<Room>> getAllRoom(){
        return new ResponseEntity<>(this.roomService.getAll(), HttpStatus.OK);
    }
}
