package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import com.codegym.meeting_room_management.dao.repository.BrRepository;
import com.codegym.meeting_room_management.service.BrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrServiceImpl implements BrService {
    @Autowired
    BrRepository brRepository;

    @Override
    public List<BookingRoom> findStartAndEndDay(String startDay, String endDay) {
        return brRepository.findStartAndEndDay(startDay, endDay);
    }

    @Override
    public List<BookingRoom> findAllRoom(Integer nameRoom) {
        return brRepository.findAllRoom(nameRoom);
    }

    @Override
    public List<BookingRoom> findAllTypeRoom(Integer nameType) {
        return brRepository.findAllTypeRoom(nameType);
    }

    @Override
    public List<BookingRoom> findAllTypeAndRoom(Integer nameRoom, Integer nameType) {
        return brRepository.findAllTypeAndRoom(nameRoom, nameType);
    }

    @Override
    public List<BookingRoom> findAllBookingDay(String bookingDay) {
        return brRepository.findAllBookingDay(bookingDay);
    }

    @Override
    public List<BookingRoom> findAllRoomAndBookingDay(Integer nameRoom, String bookingDay) {
        return brRepository.findAllRoomAndBookingDay(nameRoom, bookingDay);
    }

    @Override
    public List<BookingRoom> findAllTypeAndBookingDay(Integer nameType, String bookingDay) {
        return brRepository.findAllTypeAndBookingDay(nameType, bookingDay);
    }

    @Override
    public List<BookingRoom> findAllRoomTypeBookingDay(Integer nameRoom, Integer nameType, String bookingDay) {
        return brRepository.findAllRoomTypeBookingDay(nameRoom, nameType, bookingDay);
    }

    @Override
    public List<BookingRoom> findStartDay(String startDay) {
        return brRepository.findStartDay(startDay);
    }

    @Override
    public List<BookingRoom> findEndDay(String endDay) {
        return brRepository.findEndDay(endDay);
    }
}
