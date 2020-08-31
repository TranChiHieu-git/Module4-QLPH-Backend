package com.codegym.meeting_room_management.webservice.controller;

import com.codegym.meeting_room_management.dao.entity.Room;
import com.codegym.meeting_room_management.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    @Autowired
    private RoomService roomService;

    @GetMapping("/listRoom")
    public ResponseEntity<List<Room>> listRooms() {
        List<Room> rooms = roomService.getAllRoom();
        if (rooms == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(rooms, HttpStatus.OK);
        }
    }

    @GetMapping(value = "/room", params = {"page", "size", "search"})
    public ResponseEntity<Page<Room>> getAllCourse(@RequestParam("page") int page,
                                                    @RequestParam("size") int size,
                                                    @RequestParam("search") String search)
    {
        Page<Room> roomPage = roomService.findAllByRoomNameContainingAndAndDeleteFlagIsFalse(PageRequest.of(page,size),search);
        if (roomPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(roomPage, HttpStatus.OK);
    }

    @GetMapping("/room/{id}")
    public ResponseEntity<Room> getRoomId(@PathVariable Integer id){
        Room room = roomService.findById(id);
        if(room == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(room, HttpStatus.OK);
    }

    @PostMapping("/createRoom")
    public ResponseEntity<Void> createRoom(@RequestBody Room room) {
        roomService.save(room);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Room> updateRoom(@PathVariable("id") Integer id, @RequestBody Room room){
        Room currentRoom = roomService.findById(id);
        if(currentRoom == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            currentRoom.setId(room.getId());
            currentRoom.setRoomName(room.getRoomName());
            currentRoom.setRoomArea(room.getRoomArea());
            currentRoom.setRoomFloor(room.getRoomFloor());
            currentRoom.setRoomCapacity(room.getRoomCapacity());
//            currentRoom.setNumberOfUses(room.getNumberOfUses());
            currentRoom.setTypeRoom(room.getTypeRoom());
            currentRoom.setStatus(room.getStatus());
            currentRoom.setRegion(room.getRegion());
            roomService.save(currentRoom);
            return new ResponseEntity<Room>(currentRoom, HttpStatus.OK);
        }
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<Room> deleteRoom(@PathVariable("id") Integer id){
        Room room=roomService.findById(id);
        roomService.delete(room);
        return new ResponseEntity<Room>(HttpStatus.OK);
    }
}
