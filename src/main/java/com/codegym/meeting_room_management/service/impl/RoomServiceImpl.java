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
    public List<Room> findListWithValue(String typeMeeting, String region, String startdate, String enddate, String numberOfUser, String asset) {
        return roomRepository.findAllByTypeRoom_IdTypeRoomAndRegion_IdAndCapacityGreaterThanEqualAndDeleteFlagIsFalse(Integer.parseInt(typeMeeting), Integer.parseInt(region), Integer.parseInt(numberOfUser));
    }

    @Override
    public List<Room> findList() {
        return roomRepository.findAll();
    }

    @Override
    public Room findByIdAndDeleteFlagIsFalse(int id) {
        return roomRepository.findByIdAndDeleteFlagIsFalse(id);
    }
}
