package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RoomService {
    Page<Room> searchAllRoom(Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status);

    void save(Room room);

    void delete(Room room);

    Room findById(Integer id);

    Page<Room> findAllByNameContainingAndAndDeleteFlagIsFalse(Pageable pageable, String search);

    Page<Room> findAllRoom(Pageable pageable);

    Page<Room> searchFloorNull(Pageable pageable, String name, Integer capacity, String typeRoom, String region, String status);

    Page<Room> searchCapacityNull(Pageable pageable, String name, Integer floor, String typeRoom, String region, String status);

    Page<Room> searchAllNull(Pageable pageable, String name, String typeRoom, String region, String status);

    List<Room> findList();

    List<Room> findListWithValue(String typeMeeting, String region, String startdate, String enddate, String numberOfUser);

    /**
     * @return Room
     * @author huylm
     */
    Room findByIdAndDeleteFlagIsFalse(int id);
}
