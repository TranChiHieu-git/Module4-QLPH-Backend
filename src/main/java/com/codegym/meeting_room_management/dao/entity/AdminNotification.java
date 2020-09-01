package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.lang.reflect.AnnotatedArrayType;

@Entity
@Table(name = "admin_notification")
public class AdminNotification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @ManyToOne
            @JoinColumns({
                    @JoinColumn(name = "sender_id", referencedColumnName = "user_id"),
                    @JoinColumn(name = "sender_notification_id", referencedColumnName = "notification_id")
            })
    UserNotification sender;

    boolean deleteFlag;
    boolean seen;

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public boolean isSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public AdminNotification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public UserNotification getSender() {
        return sender;
    }

    public void setSender(UserNotification sender) {
        this.sender = sender;
    }
}
