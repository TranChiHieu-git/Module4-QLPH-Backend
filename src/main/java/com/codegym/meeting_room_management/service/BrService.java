package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;

import java.util.List;

public interface BrService {
    List<BookingRoom> findStartAndEndDay(String startDay, String endDay);
    List<BookingRoom> findAllRoom(Integer nameRoom);
    List<BookingRoom> findAllTypeRoom(Integer nameType);
    List<BookingRoom> findAllTypeAndRoom(Integer nameRoom, Integer nameType);
    List<BookingRoom> findAllBookingDay(String bookingDay);
    List<BookingRoom> findAllRoomAndBookingDay(Integer nameRoom, String bookingDay);
    List<BookingRoom> findAllTypeAndBookingDay(Integer nameType, String bookingDay);
    List<BookingRoom> findAllRoomTypeBookingDay(Integer nameRoom, Integer nameType, String bookingDay);
    List<BookingRoom> findStartDay(String startDay);
    List<BookingRoom> findEndDay(String endDay);
}
