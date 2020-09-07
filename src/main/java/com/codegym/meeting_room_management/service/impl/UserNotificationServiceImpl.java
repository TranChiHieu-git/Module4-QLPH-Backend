package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import com.codegym.meeting_room_management.dao.repository.UserNotificationRepository;
import com.codegym.meeting_room_management.service.UserNotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserNotificationServiceImpl implements UserNotificationService {
    @Autowired
    UserNotificationRepository userNotificationRepository;

    @Override
    public Page<UserNotification> getAllByUserId(int id, Pageable pageable) {
        return userNotificationRepository.getAllByUserIDDeleteFlagIsFalse(id, pageable);
    }

    @Override
    public void save(UserNotification userNotification) {
        userNotificationRepository.save(userNotification);
    }

    @Override
    public void markAsSeenById(int id) {
        userNotificationRepository.markAsSeenById(id);
    }

    @Override
    public void deleteById(int id) {
        userNotificationRepository.deleteById(id);
    }

}
