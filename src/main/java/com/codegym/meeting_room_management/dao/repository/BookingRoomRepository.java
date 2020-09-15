package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

@Repository
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public interface BookingRoomRepository extends JpaRepository<BookingRoom, Integer> {
}
