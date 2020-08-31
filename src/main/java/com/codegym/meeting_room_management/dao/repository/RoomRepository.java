package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    List<Room> findAllByDeleteFlagIsFalse();
    Room findRoomByIdAndDeleteFlagIsFalse(Integer id);
    Page<Room> findAllByRoomNameContainingAndDeleteFlagIsFalse(Pageable pageable, String search);
}
