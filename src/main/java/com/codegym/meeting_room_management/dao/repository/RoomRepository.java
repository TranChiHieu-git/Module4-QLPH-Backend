package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
    Page<Room> findAllByDeleteFlagIsFalse(Pageable pageable);

    Room findRoomByIdAndDeleteFlagIsFalse(Integer id);

    Page<Room> findAllByNameContainingAndDeleteFlagIsFalse(Pageable pageable, String search);

    Page<Room> findAllByNameContainingAndFloorAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_RegionNameContainingAndStatus_StatusNameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );
    Page<Room> findAllByNameContainingAndFloorLessThanEqualAndCapacityLessThanEqualAndTypeRoom_NameTypeRoomContainingAndRegion_RegionNameContainingAndStatus_StatusNameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );
    Page<Room> findAllByNameContainingAndFloorLessThanEqualAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_RegionNameContainingAndStatus_StatusNameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );
    Page<Room> findAllByNameContainingAndFloorAndCapacityLessThanEqualAndTypeRoom_NameTypeRoomContainingAndRegion_RegionNameContainingAndStatus_StatusNameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );
}
