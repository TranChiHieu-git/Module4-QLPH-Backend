package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.TypeRoom;
import com.codegym.meeting_room_management.dao.repository.TypeRoomRepository;
import com.codegym.meeting_room_management.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeRoomServiceImpl implements TypeRoomService {
    @Autowired
    TypeRoomRepository typeRoomRepository;

    @Override
    public List<TypeRoom> findList() {
        return typeRoomRepository.findAll();
    }
}
