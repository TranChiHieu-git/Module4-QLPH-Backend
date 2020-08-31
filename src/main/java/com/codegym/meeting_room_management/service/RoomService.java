package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    List<Room> getAllRoom();
    void save(Room room);
    void delete(Room room);
    Room findById(Integer id);
    Page<Room> findAllByRoomNameContainingAndAndDeleteFlagIsFalse(Pageable pageable, String search);
}
