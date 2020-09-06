package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String content;
    @ManyToOne
    @JoinColumn(name="room_id", referencedColumnName = "id")
    Room room;
    Date requestDate;
    Date repondDate;
    String status;
    @ManyToOne
    @JoinColumn(name="type_of_notification_id", referencedColumnName = "id")
    TypeOfNotification typeOfNotification;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Date getRepondDate() {
        return repondDate;
    }

    public void setRepondDate(Date repondDate) {
        this.repondDate = repondDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TypeOfNotification getTypeOfNotification() {
        return typeOfNotification;
    }

    public void setTypeOfNotification(TypeOfNotification typeOfNotification) {
        this.typeOfNotification = typeOfNotification;
    }

    public Notification() {
    }
}
