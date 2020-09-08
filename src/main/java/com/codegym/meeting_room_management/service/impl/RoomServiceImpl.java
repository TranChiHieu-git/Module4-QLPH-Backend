package com.codegym.meeting_room_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.dao.repository.RoomRepository;
import com.codegym.meeting_room_management.service.RoomService;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomRepository roomRepository;

    @Override
    public Page<Room> searchAllRoom(Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status) {
        return roomRepository.findAllByNameContainingAndFloorAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(pageable, name, floor, capacity, typeRoom, region, status);
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
    public Page<Room> findAllByNameContainingAndAndDeleteFlagIsFalse(Pageable pageable, String search) {
        return roomRepository.findAllByNameContainingAndDeleteFlagIsFalse(pageable, search);
    }

    @Override
    public Page<Room> findAllRoom(Pageable pageable) {
        return roomRepository.findAll(pageable);
    }

    @Override
    public Page<Room> searchFloorNull(Pageable pageable, String name, Integer capacity, String typeRoom, String region, String status) {
        return roomRepository.findAllByNameContainingAndFloorLessThanEqualAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(pageable, name, 20, capacity, typeRoom, region, status);
    }

    @Override
    public Page<Room> searchCapacityNull(Pageable pageable, String name, Integer floor, String typeRoom, String region, String status) {
        return roomRepository.findAllByNameContainingAndFloorAndCapacityLessThanEqualAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(pageable, name, floor, 20, typeRoom, region, status);
    }

    @Override
    public Page<Room> searchAllNull(Pageable pageable, String name, String typeRoom, String region, String status) {
        return roomRepository.findAllByNameContainingAndFloorLessThanEqualAndCapacityLessThanEqualAndAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(pageable, name, 20, 20, typeRoom, region, status);
    }
    @Override
    public List<Room> findListWithValue(String typeMeeting, String region, String startdate, String enddate, String numberOfUser, String asset) {
        String ex = asset.split(",")[0];
        return roomRepository.findListWithValue(Integer.parseInt(typeMeeting), Integer.parseInt(region), Integer.parseInt(numberOfUser), ex);
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
