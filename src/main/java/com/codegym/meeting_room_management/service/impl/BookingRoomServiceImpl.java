package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import com.codegym.meeting_room_management.dao.repository.BookingRoomRepository;
import com.codegym.meeting_room_management.service.BookingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingRoomServiceImpl implements BookingRoomService {

    @Autowired
    BookingRoomRepository bookingRoomRepository;

    @Override
    public void save(BookingRoom bookingRoom) {
        bookingRoomRepository.save(bookingRoom);
    }
}
