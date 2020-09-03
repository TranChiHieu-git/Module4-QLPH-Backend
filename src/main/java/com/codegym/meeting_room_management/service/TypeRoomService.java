package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.TypeRoom;

import java.util.List;

public interface TypeRoomService {
    List<TypeRoom> findList();
}
