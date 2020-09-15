package com.codegym.meeting_room_management.webservice.controller.UserController;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.dao.entity.TypeRoom;
import com.codegym.meeting_room_management.service.BrService;
import com.codegym.meeting_room_management.service.RoomService;
import com.codegym.meeting_room_management.service.TypeRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class StatisticController {
    @Autowired
    private BrService brService;
    @Autowired
    private RoomService roomService;
    @Autowired
    private TypeRoomService typeRoomService;
    /*List room and list type room*/
    @RequestMapping(value = "/allRoom/", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> listAllRoom() {
        List<Room> rooms = roomService.findList();
        return rooms.isEmpty() ? new ResponseEntity<List<Room>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<Room>>(rooms, HttpStatus.OK);//You many decide to return HttpStatus.NOT_FOUND
    }
    @RequestMapping(value = "/allType/", method = RequestMethod.GET)
    public ResponseEntity<List<TypeRoom>> listAllType() {
        List<TypeRoom> typeRooms = typeRoomService.findList();
        return typeRooms.isEmpty() ? new ResponseEntity<List<TypeRoom>>(HttpStatus.NO_CONTENT) : new ResponseEntity<List<TypeRoom>>(typeRooms, HttpStatus.OK);//You many decide to return HttpStatus.NOT_FOUND
    }
    /*End list room and type room*/

    /* Statistic follow Room*/
    @RequestMapping(value = "/room/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllRoom(@RequestParam(value = "nameRoom") Integer nameRoom) {
        List<BookingRoom> bookingRooms = brService.findAllRoom(nameRoom);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/type/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllType(@RequestParam(value = "nameType") Integer nameType) {
        List<BookingRoom> bookingRooms = brService.findAllTypeRoom(nameType);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/typeAndRoom/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllTypeAndRoom(@RequestParam(value = "nameRoom") Integer nameRoom, @RequestParam(value = "nameType") Integer nameType) {
        List<BookingRoom> bookingRooms = brService.findAllTypeAndRoom(nameRoom, nameType);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/bookingDay/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllBookingDay(@RequestParam(value = "bookingDay") String bookingDay) {
        List<BookingRoom> bookingRooms = brService.findAllBookingDay(bookingDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/roomAndBookingDay/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllRoomAndBookingDay(@RequestParam(value = "nameRoom") Integer nameRoom, @RequestParam(value = "bookingDay") String bookingDay) {
        List<BookingRoom> bookingRooms = brService.findAllRoomAndBookingDay(nameRoom, bookingDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/typeAndBookingDay/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllTypeAndBookingDay(@RequestParam(value = "nameType") Integer nameType, @RequestParam(value = "bookingDay") String bookingDay) {
        List<BookingRoom> bookingRooms = brService.findAllTypeAndBookingDay(nameType, bookingDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    @RequestMapping(value = "/roomTypeBookingDay/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllRoomTypeBookingDay(@RequestParam(value = "nameRoom") Integer nameRoom, @RequestParam(value = "nameType") Integer nameType, @RequestParam(value = "bookingDay") String bookingDay) {
        List<BookingRoom> bookingRooms = brService.findAllRoomTypeBookingDay(nameRoom, nameType, bookingDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    /*End statistic follow room*/

    /*Statistic follow Time*/
    @RequestMapping(value = "/startAndEnd/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllStartEnd(@RequestParam(value = "startDay") String startDay, @RequestParam(value = "endDay") String endDay) {
        List<BookingRoom> bookingRooms = brService.findStartAndEndDay(startDay, endDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/start/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllStart(@RequestParam(value = "startDay") String startDay) {
        List<BookingRoom> bookingRooms = brService.findStartDay(startDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }

    @RequestMapping(value = "/end/", method = RequestMethod.GET)
    public ResponseEntity<List<BookingRoom>> listAllEnd(@RequestParam(value = "endDay") String endDay) {
        List<BookingRoom> bookingRooms = brService.findEndDay(endDay);
        return bookingRooms.isEmpty() ? new ResponseEntity<List<BookingRoom>>(HttpStatus.NOT_FOUND) : new ResponseEntity<List<BookingRoom>>(bookingRooms, HttpStatus.OK);
    }
    /*End statistic follow Time*/
}
