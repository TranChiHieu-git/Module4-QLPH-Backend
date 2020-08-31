package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_room")
public class BookingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private int idBooking;
    @Column(name = "booking_day")
    private Date bookingDate;
    @Column(name = "start_day")
    private Date startDate;
    @Column(name = "end_day")
    private Date endDate;
    @Column(name = "start_time")
    private Date startTime;
    @Column(name = "end_time")
    private Date endTime;
    @Column(name = "description_meeting")
    private String descriptionMeeting;
    @Column(name = "delete_flag")
    private boolean deleteFlag;
    @Column(name = "booking_status")
    private String bookingStatus;
    @ManyToOne
    @JoinColumn(name = "id_type_meeting")
    private TypeMeeting typeMeeting;
    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    public BookingRoom() {
    }

    public BookingRoom(Date bookingDate, Date startDate, Date endDate, Date startTime, Date endTime,
                       String descriptionMeeting, boolean deleteFlag, String bookingStatus, TypeMeeting typeMeeting,
                       Room room, User user) {
        this.bookingDate = bookingDate;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.descriptionMeeting = descriptionMeeting;
        this.deleteFlag = deleteFlag;
        this.bookingStatus = bookingStatus;
        this.typeMeeting = typeMeeting;
        this.room = room;
        this.user = user;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescriptionMeeting() {
        return descriptionMeeting;
    }

    public void setDescriptionMeeting(String descriptionMeeting) {
        this.descriptionMeeting = descriptionMeeting;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public TypeMeeting getTypeMeeting() {
        return typeMeeting;
    }

    public void setTypeMeeting(TypeMeeting typeMeeting) {
        this.typeMeeting = typeMeeting;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
