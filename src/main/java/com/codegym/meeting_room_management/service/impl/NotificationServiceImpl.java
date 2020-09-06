package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Notification;
import com.codegym.meeting_room_management.dao.repository.NotificationRepository;
import com.codegym.meeting_room_management.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {
    @Autowired
    NotificationRepository notificationRepository;

    @Override
    public void save(Notification notification) {
        this.notificationRepository.save(notification);
    }
}
