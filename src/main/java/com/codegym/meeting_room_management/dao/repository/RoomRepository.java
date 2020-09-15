package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {
    @Query(value = "SELECT Room.id, Room.name, Room.area, Room.floor, Room.capacity, Room.delete_flag, " +
            "Room.id_type_room, Room.id_region, Room.id_status FROM Room left join booking_room " +
            "on room.id = booking_room.id_room WHERE (Room.id_type_room like ?1 AND Room.id_region " +
            "like ?2 AND Room.capacity >= ?3 AND Room.delete_flag = 0) " +
            "and Room.id  not in ( select booking_room.id_room from booking_room where (" +
            "(booking_room.start_day = ?4 and booking_room.end_day = ?6) and ((" +
            "(booking_room.start_time <= ?5 and ?5 <= booking_room.end_time) or" +
            "(booking_room.start_time <= ?7 and ?7 <= booking_room.end_time)))) " +
            "group by booking_room.id_booking)" +
            "group by Room.id"
            , nativeQuery = true)
    List<Room> findListWithValueOnce(String typeroom, String region, int capacity,
                                     String startDay, String startTime, String endDay, String endTime);

    @Query(value = "SELECT Room.id, Room.name, Room.area, Room.floor, Room.capacity, Room.delete_flag, " +
            "Room.id_type_room, Room.id_region, Room.id_status FROM Room left join booking_room " +
            "on room.id = booking_room.id_room WHERE (Room.id_type_room like ?1 AND Room.id_region " +
            "like ?2 AND Room.capacity >= ?3 AND Room.delete_flag = 0) " +
            "and Room.id  not in ( select booking_room.id_room from booking_room where (" +
            "(((booking_room.start_day <= ?4) and  (?4 <= booking_room.end_day)) or" +
            "((booking_room.start_day <= ?6) and (?6 <= booking_room.end_day))) and ((" +
            "(booking_room.start_time <= ?5 and ?5 <= booking_room.end_time) or" +
            "(booking_room.start_time <= ?7 and ?7 <= booking_room.end_time)))) " +
            "group by booking_room.id_booking)" +
            "group by Room.id"
            , nativeQuery = true)
    List<Room> findListWithValueDaily(String typeroom, String region, int capacity,
                                      String startDay, String startTime, String endDay, String endTime);

    @Query(value = "SELECT Room.id, Room.name, Room.area, Room.floor, Room.capacity, Room.delete_flag, " +
            "Room.id_type_room, Room.id_region, Room.id_status FROM Room left join booking_room " +
            "on room.id = booking_room.id_room WHERE (Room.id_type_room like ?1 AND Room.id_region " +
            "like ?2 AND Room.capacity >= ?3 AND Room.delete_flag = 0) " +
            "and Room.id  not in ( select booking_room.id_room from booking_room where (" +
            "(((booking_room.start_day <= ?4) and  (?4 <= booking_room.end_day)) or" +
            "((booking_room.start_day <= ?6) and (?6 <= booking_room.end_day))) and ((" +
            "(booking_room.start_time <= ?5 and ?5 <= booking_room.end_time) or" +
            "(booking_room.start_time <= ?7 and ?7 <= booking_room.end_time)))) " +
            "group by booking_room.id_booking)" +
            "group by Room.id"
            , nativeQuery = true)
    List<Room> findListWithValueWeekly(String typeroom, String region, int capacity,
                                       String startDay, String startTime, String endDay, String endTime);

    @Query(value = "SELECT Room.id, Room.name, Room.area, Room.floor, Room.capacity, Room.delete_flag, " +
            "Room.id_type_room, Room.id_region, Room.id_status FROM Room left join booking_room on " +
            "room.id = booking_room.id_room where (Room.id_type_room like ?1 AND Room.id_region like ?2 AND " +
            "Room.capacity >= ?3 AND Room.delete_flag = 0) and Room.id  not in (select booking_room.id_room from " +
            "booking_room where ((((booking_room.start_day <= ?4) and  " +
            "(?4 <= booking_room.end_day)) or ((booking_room.start_day <= ?6) and " +
            "(?6 <= booking_room.end_day))) and ( booking_room.start_time <= ?5 and " +
            "?5 <= booking_room.end_time or booking_room.start_time <= ?7 and " +
            "?7 <= booking_room.end_time)) group by booking_room.id_booking ) group by Room.id;"
            , nativeQuery = true)
    List<Room> findListWithValueMonthly(String typeroom, String region, int capacity,
                                        String startDay, String startTime, String endDay, String endTime);

    /**
     * @return Room
     * @author huylm
     */
    Room findByIdAndDeleteFlagIsFalse(int id);

    List<Room> findAllByTypeRoom_IdTypeRoomAndRegion_IdAndCapacityGreaterThanEqualAndDeleteFlagIsFalse(int typeroom, int region, int capacity);


    Page<Room> findAllByDeleteFlagIsFalse(Pageable pageable);

    Room findRoomByIdAndDeleteFlagIsFalse(Integer id);

    Page<Room> findAllByNameContainingAndDeleteFlagIsFalse(Pageable pageable, String search);

    Page<Room> findAllByNameContainingAndFloorAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );

    Page<Room> findAllByNameContainingAndFloorLessThanEqualAndCapacityLessThanEqualAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );

    Page<Room> findAllByNameContainingAndFloorLessThanEqualAndCapacityAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );

    Page<Room> findAllByNameContainingAndFloorAndCapacityLessThanEqualAndTypeRoom_NameTypeRoomContainingAndRegion_NameContainingAndStatus_NameContainingAndDeleteFlagIsFalse(
            Pageable pageable, String name, Integer floor, Integer capacity, String typeRoom, String region, String status
    );
}
