package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface UserNotificationService {
    Page<UserNotification> getAllByUserId(int id, Pageable pageable);
    void save(UserNotification userNotification);
    void markAsSeenById(int id);
    void deleteById(int id);
    List<UserNotification> getAllByDeleteFlagIsFalse(int id);
 }
