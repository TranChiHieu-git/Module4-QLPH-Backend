package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.AdminNotification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminNotificationRepository extends JpaRepository<AdminNotification, Integer> {
}
