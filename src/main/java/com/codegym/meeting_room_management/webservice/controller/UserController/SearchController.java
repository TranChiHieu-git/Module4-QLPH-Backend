package com.codegym.meeting_room_management.webservice.controller.UserController;

import com.codegym.meeting_room_management.dao.DTO.RoomDTO;
import com.codegym.meeting_room_management.dao.entity.*;
import com.codegym.meeting_room_management.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @Autowired
    AssetSer assetSer;

    @RequestMapping(value = "/user/search-room", method = RequestMethod.GET, params = {"typemeeting", "region",
            "startdate", "enddate", "numberofuser", "asset"})
    public ResponseEntity<List<RoomDTO>> listRoomResultSearch(@RequestParam("typemeeting") String typeMeeting,
                                                              @RequestParam("region") String region,
                                                              @RequestParam("startdate") String startdate,
                                                              @RequestParam("enddate") String enddate,
                                                              @RequestParam("numberofuser") String numberOfUser,
                                                              @RequestParam("asset") String asset) {
        List<Room> resultRoomList = roomService.findListWithValue(typeMeeting, region, startdate, enddate, numberOfUser);
        List<RoomDTO> resultRoomDTOList = new ArrayList<>();
        for (Room room : resultRoomList) {
            String assetWithId = assetSer.assetSer(room.getId());
            String assetWithIdreturnId = assetSer.assetSerId(room.getId());
            String[] checkListAsset = asset.split(",");
            boolean flag = true;
            for (String s : checkListAsset) {
                if (!assetWithIdreturnId.contains(s)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                resultRoomDTOList.add(new RoomDTO(room.getId(), room.getName(),
                        room.getFloor(), room.getCapacity(),
                        room.getArea(), assetWithId));
            }
        }
        return new ResponseEntity<>(resultRoomDTOList, HttpStatus.OK);
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
