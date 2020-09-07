package com.codegym.meeting_room_management.webservice.controller.UserController;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.service.BookingRoomService;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class BookingRoomController {
    @Autowired
    RoomService roomService;

    @Autowired
    BookingRoomService bookingRoomService;

    @GetMapping("/getRoomById/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable("id") Integer id) {
        Room room = roomService.findByIdAndDeleteFlagIsFalse(id);

        return room == null ? new ResponseEntity<Room>(HttpStatus.NOT_FOUND) : new ResponseEntity<Room>(room, HttpStatus.OK);
    }

    @PostMapping("/createBookingRoom")
    public ResponseEntity<Void> createBookingRoom(@RequestBody BookingRoom bookingRoom) {
        bookingRoomService.save(bookingRoom);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

}
