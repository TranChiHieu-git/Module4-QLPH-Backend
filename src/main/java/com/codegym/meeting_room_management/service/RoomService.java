package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Room;

import java.util.List;

public interface RoomService {
    List<Room> findList();
    List<Room> findListWithValue(String typeMeeting, String region, String startdate, String enddate, String numberOfUser, String asset);
}
