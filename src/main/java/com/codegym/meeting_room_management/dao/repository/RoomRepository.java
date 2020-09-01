package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}
