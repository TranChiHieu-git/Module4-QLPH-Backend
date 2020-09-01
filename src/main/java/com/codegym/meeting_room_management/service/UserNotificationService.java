package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserNotificationService {
    List<UserNotification> getAllByUserId(int id);
 }
