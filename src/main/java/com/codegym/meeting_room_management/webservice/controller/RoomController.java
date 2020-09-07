package com.codegym.meeting_room_management.webservice.controller;

import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class RoomController {
    @Autowired
    RoomService roomService;

    //    list room search
    @RequestMapping(value = "/admin/room-search", method = RequestMethod.GET)
    public ResponseEntity<Page<Room>> listRoomSearch(@RequestParam("page") int page,
                                               @RequestParam("size") int size,
                                               @RequestParam("name") String name,
                                               @RequestParam("floor") Integer floor,
                                               @RequestParam("capacity") Integer capacity,
                                               @RequestParam("typeRoom") String typeRoom,
                                               @RequestParam("region") String region,
                                               @RequestParam("status") String status) {
        Page<Room> roomPage;
        if(floor != null && capacity != null){
            roomPage = roomService.searchAllRoom(PageRequest.of(page, size, Sort.by("id").ascending()),
                    name, floor, capacity, typeRoom, region, status);
        }else if(floor == null && capacity != null){
            roomPage = roomService.searchFloorNull(PageRequest.of(page, size, Sort.by("id").ascending()),
                    name, capacity, typeRoom, region, status);
        }else if(floor != null && capacity == null){
            roomPage = roomService.searchCapacityNull(PageRequest.of(page, size, Sort.by("id").ascending()),
                    name, floor, typeRoom, region, status);
        }else {
            roomPage = roomService.searchAllNull(PageRequest.of(page, size, Sort.by("id").ascending()),
                    name, typeRoom, region, status);
        }

        if (roomPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomPage, HttpStatus.OK);
    }

    //    list room
    @RequestMapping(value = "/admin/room", method = RequestMethod.GET)
    public ResponseEntity<Page<Room>> listRoom(@RequestParam("page") int page,
                                               @RequestParam("size") int size) {
        Page<Room> roomPage = roomService.findAllRoom(PageRequest.of(page, size, Sort.by("id").ascending()));
        if (roomPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomPage, HttpStatus.OK);
    }
}
