package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT Room.id, Room.name, Room.area, Room.floor, Room.capacity, Room.delete_flag, " +
            "Room.id_type_room, Room.id_region, Room.id_status, asset.name, group_concat(asset.name, \" \") as asset FROM " +
            "Room left join booking_room " +
            "on room.id = booking_room.id_room left join meeting_room_asset " +
            "on room.id = meeting_room_asset.id_room left join asset " +
            "on asset.id = meeting_room_asset.id_asset where " +
            "(Room.id_type_room = ?1 AND Room.id_region = ?2 AND Room.capacity >= ?3 AND Room.delete_flag = 0)" +
            "And (?4 IN (select id from asset join meeting_room_asset on meeting_room_asset.id_asset = asset.id where id_room = Room.id))" +
            "GROUP BY Room.id;",
            nativeQuery = true)
    List<Room> findListWithValue(int typeroom, int region, int capacity, String asset);
}
