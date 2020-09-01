package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import com.codegym.meeting_room_management.dao.repository.UserNotificationRepository;
import com.codegym.meeting_room_management.service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserNotificationServiceImpl implements UserNotificationService {
    @Autowired
    UserNotificationRepository userNotificationRepository;
    @Override
    public List<UserNotification> getAllByUserId(int id) {
        return userNotificationRepository.findAllByUserId(id);
    }
}
