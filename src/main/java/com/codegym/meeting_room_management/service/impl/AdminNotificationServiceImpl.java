package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.AdminNotification;
import com.codegym.meeting_room_management.dao.repository.AdminNotificationRepository;
import com.codegym.meeting_room_management.service.AdminNotificationService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminNotificationServiceImpl implements AdminNotificationService {
    @Autowired
    AdminNotificationRepository adminRepo;
    @Override
    public List<AdminNotification> getAll() {
        return adminRepo.findAll();
    }
}
