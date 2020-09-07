package com.codegym.meeting_room_management.dao.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "booking_room")
public class BookingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_booking")
    private int idBooking;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_booking_day")
    private Date createBookingDay;

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
    @JoinColumn(name = "id_room")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "users")
    private User user;

    @Column(name = "request_other")
    private String requestOther;
    @Column(name = "start_day")
    private Date startDay;

    @Column(name = "end_day")
    private Date endDay;
    public BookingRoom() {

    }

    public Date getStartDay() {
        return startDay;
    }

    public void setStartDay(Date startDay) {
        this.startDay = startDay;
    }

    public Date getEndDay() {
        return endDay;
    }

    public void setEndDay(Date endDay) {
        this.endDay = endDay;
    }

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public Date getCreateBookingDay() {
        return createBookingDay;
    }

    public void setCreateBookingDay(Date createBookingDay) {
        this.createBookingDay = createBookingDay;
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

    public String getRequestOther() {
        return requestOther;
    }

    public void setRequestOther(String requestOther) {
        this.requestOther = requestOther;
    }
}
