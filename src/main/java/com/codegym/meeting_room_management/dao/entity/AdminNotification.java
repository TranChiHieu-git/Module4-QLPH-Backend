package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "admin_notification")
public class AdminNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JoinColumn(name = "sender_notification_id", referencedColumnName = "id")
    UserNotification sender;

    @ManyToOne
    @JoinColumn(name = "handler_notification_id", referencedColumnName = "id")
    UserNotification handler;


    boolean deleteFlag;
    boolean seen;

    public int getId() {
        return id;
    }

    public UserNotification getSender() {
        return sender;
    }

    public UserNotification getHandler() {
        return handler;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public boolean isSeen() {
        return seen;
    }

    public AdminNotification(UserNotification sender, UserNotification handler, boolean deleteFlag, boolean seen) {
        this.sender = sender;
        this.handler = handler;
        this.deleteFlag = deleteFlag;
        this.seen = seen;
    }
}
