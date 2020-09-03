package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.dao.repository.RoomRepository;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;

    @Override
    public List<Room> findList() {
        return roomRepository.findAll();
    }
}
