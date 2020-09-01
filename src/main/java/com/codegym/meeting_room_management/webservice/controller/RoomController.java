package com.codegym.meeting_room_management.webservice.controller;

import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class RoomController {
    @Autowired
    RoomService roomService;

//    list room
    @RequestMapping(value = "/admin/room", method = RequestMethod.GET)
    public ResponseEntity<List<Room>> listRoom(){
        List<Room> roomPage = roomService.findAllRoom();
        if(roomPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomPage,HttpStatus.OK);
    }
}
