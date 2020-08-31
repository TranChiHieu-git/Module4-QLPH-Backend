package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.dao.repository.RoomRepository;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;
    @Override
    public List<Room> getAllRoom() {
        return roomRepository.findAllByDeleteFlagIsFalse();
    }

    @Override
    public void save(Room room) {
        roomRepository.save(room);
    }

    @Override
    public void delete(Room room) {
        room.setDeleteFlag(true);
        save(room);
    }

    @Override
    public Room findById(Integer id) {
        return roomRepository.findRoomByIdAndDeleteFlagIsFalse(id);
    }

    @Override
    public Page<Room> findAllByRoomNameContainingAndAndDeleteFlagIsFalse(Pageable pageable, String search) {
        return roomRepository.findAllByRoomNameContainingAndDeleteFlagIsFalse(pageable,search);
    }
}
