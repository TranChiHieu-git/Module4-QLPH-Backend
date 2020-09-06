package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.AdminNotification;

import java.util.List;

public interface AdminNotificationService {

   List<AdminNotification> getAll();
   void save(AdminNotification adminNotification);
}
