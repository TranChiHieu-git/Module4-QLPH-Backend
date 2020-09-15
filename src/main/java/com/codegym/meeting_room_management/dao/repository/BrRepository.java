package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.BookingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrRepository extends JpaRepository<BookingRoom, Integer> {
    /*Phần query của Duẫn*/
    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "where (management_booking.booking_room.start_day=:startDay and management_booking.booking_room.end_day=:endDay)",
            nativeQuery = true)
    List<BookingRoom> findStartAndEndDay(@Param("startDay") String startDay, @Param("endDay") String endDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "where (management_booking.booking_room.start_day=:startDay)",
            nativeQuery = true)
    List<BookingRoom> findStartDay(@Param("startDay") String startDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "where (management_booking.booking_room.end_day=:endDay)",
            nativeQuery = true)
    List<BookingRoom> findEndDay(@Param("endDay") String endDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "where (management_booking.room.id= :nameRoom)",
            nativeQuery = true)
    List<BookingRoom> findAllRoom(@Param("nameRoom") Integer nameRoom);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "join management_booking.type_room on management_booking.type_room.id_type_room=management_booking.room.id\n" +
            "where (management_booking.type_room.id_type_room= :nameType)",
            nativeQuery = true)
    List<BookingRoom> findAllTypeRoom(@Param("nameType") Integer nameType);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "join management_booking.type_room on management_booking.type_room.id_type_room=management_booking.room.id\n" +
            "where (management_booking.room.id= :nameRoom and management_booking.type_room.id_type_room= :nameType)",
            nativeQuery = true)
    List<BookingRoom> findAllTypeAndRoom(@Param("nameRoom") Integer nameRoom, @Param("nameType") Integer nameType);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "where (management_booking.booking_room.create_booking_day=:bookingDay)",
            nativeQuery = true)
    List<BookingRoom> findAllBookingDay(@Param("bookingDay") String bookingDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "where (management_booking.room.id=:nameRoom and management_booking.booking_room.create_booking_day=:bookingDay)",
            nativeQuery = true)
    List<BookingRoom> findAllRoomAndBookingDay(@Param("nameRoom") Integer nameRoom, @Param("bookingDay") String bookingDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "join management_booking.type_room on management_booking.type_room.id_type_room=management_booking.room.id\n" +
            "where (management_booking.type_room.id_type_room=:nameType and management_booking.booking_room.create_booking_day=:bookingDay)",
            nativeQuery = true)
    List<BookingRoom> findAllTypeAndBookingDay(@Param("nameType") Integer nameType, @Param("bookingDay") String bookingDay);

    @Query(value = "SELECT*\n" +
            "FROM management_booking.booking_room\n" +
            "join management_booking.room on management_booking.booking_room.id_room=management_booking.room.id\n" +
            "join management_booking.type_room on management_booking.type_room.id_type_room=management_booking.room.id\n" +
            "where (management_booking.type_room.id_type_room=:nameType and management_booking.booking_room.create_booking_day=:bookingDay and management_booking.room.id=:nameRoom)",
            nativeQuery = true)
    List<BookingRoom> findAllRoomTypeBookingDay(@Param("nameRoom") Integer nameRoom, @Param("nameType") Integer nameType, @Param("bookingDay") String bookingDay);
    /*Kết thúc query của Duẫn*/
}
