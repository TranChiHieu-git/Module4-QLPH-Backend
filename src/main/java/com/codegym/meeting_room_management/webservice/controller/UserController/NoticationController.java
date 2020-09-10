package com.codegym.meeting_room_management.webservice.controller.UserController;

import com.codegym.meeting_room_management.dao.entity.*;
import com.codegym.meeting_room_management.dao.repository.AdminNotificationRepository;
import com.codegym.meeting_room_management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(allowedHeaders = "*")
public class NoticationController {
    @Autowired
    UserNotificationService userNotificationService;
    @Autowired
    AdminNotificationService adminNotificationService;
    @Autowired
    NotificationService notificationService;
    @Autowired
    RoomService roomService;
    @Autowired
    UserService userService;


    @PostMapping("/user/notification/{id}")
    public Page<UserNotification> getAllByUserId(@PathVariable int id, @RequestBody MyPageable pageable) {
        Pageable pageableBE;
        if (pageable.getMySort() == null) {
            pageableBE = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize());

        } else {
            pageableBE = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), pageable.getMySort().getSort());
        }

        Page<UserNotification> page = userNotificationService.getAllByUserId(id, pageableBE);
        return page;
    }

    @Transactional
    @PostMapping("/user/notification/{id}/save")
    public ResponseEntity<String> saveNotification(@PathVariable int id, @RequestBody Notification notification) {
        this.notificationService.save(notification);
        User user = this.userService.findById(id);
        UserNotification userNotification = new UserNotification(user, notification, false, true);
         userNotificationService.save(userNotification);
        AdminNotification adminNotification = new AdminNotification(userNotification, null, false, false);
        adminNotificationService.save(adminNotification);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/user/notification/markSeen/{id}")
    public ResponseEntity<Boolean> markAsSeen(@PathVariable int id) {
        userNotificationService.markAsSeenById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @GetMapping("/user/notification/delete/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable int id) {
        userNotificationService.deleteById(id);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }


    @GetMapping("/user/room/all")
    public ResponseEntity<List<Room>> getAllRoom() {
        return new ResponseEntity<>(this.roomService.findList(), HttpStatus.OK);
    }

    @GetMapping("user/notification/{id}/notSeen")
    public List<UserNotification> getAllByDeleteFlagIsFalse(@PathVariable int id){
        return this.userNotificationService.getAllByDeleteFlagIsFalse(id);
    }
}
