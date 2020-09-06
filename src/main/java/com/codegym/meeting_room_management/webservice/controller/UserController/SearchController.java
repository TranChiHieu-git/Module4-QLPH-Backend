package com.codegym.meeting_room_management.webservice.controller.UserController;

import com.codegym.meeting_room_management.dao.entity.*;
import com.codegym.meeting_room_management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*", exposedHeaders = "Authorization")
public class SearchController {
    @Autowired
    RoomService roomService;
    @Autowired
    RegionService regionService;
    @Autowired
    StatusService statusService;
    @Autowired
    TypeRoomService typeRoomService;

    @RequestMapping(value = "/user/search-room", method = RequestMethod.GET, params = {"typemeeting", "region",
            "startdate", "enddate", "numberofuser", "asset"})
    public ResponseEntity<List<Room>> listRoomResultSearch(@RequestParam("typemeeting") String typeMeeting,
                                                           @RequestParam("region") String region,
                                                           @RequestParam("startdate") String startdate,
                                                           @RequestParam("enddate") String enddate,
                                                           @RequestParam("numberofuser") String numberOfUser,
                                                           @RequestParam("asset") String asset) {
        System.out.println(typeMeeting+" "+region+" "+numberOfUser);
        return new ResponseEntity<>(roomService.findList(typeMeeting, region, startdate, enddate, numberOfUser, asset), HttpStatus.OK);
    }

    //============================================ get support table ================================================
    @RequestMapping(value = "/get/region", method = RequestMethod.GET)
    public ResponseEntity<List<Region>> listRegion() {
        return new ResponseEntity<>(regionService.findList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/status", method = RequestMethod.GET)
    public ResponseEntity<List<Status>> listStatus() {
        return new ResponseEntity<>(statusService.findList(), HttpStatus.OK);
    }

    @RequestMapping(value = "/get/typeroom", method = RequestMethod.GET)
    public ResponseEntity<List<TypeRoom>> listTypeRoom() {
        return new ResponseEntity<>(typeRoomService.findList(), HttpStatus.OK);
    }
}
