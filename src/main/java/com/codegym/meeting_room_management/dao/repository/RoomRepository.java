package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    List<Room> findAllByTypeRoom_IdTypeRoomAndRegion_IdAndCapacityGreaterThanEqualAndDeleteFlagIsFalse(int typeroom, int region, int capacity);
}
