package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRoomRepository extends JpaRepository<BookingRoom, Integer> {
}
