package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_notification")
public class UserNotification {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    private Notification notification;
    private boolean deleteFlag;
    private boolean seen;



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

    public UserNotification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public UserNotification(int id, User user, Notification notification, boolean deleteFlag, boolean seen) {
        this.id = id;
        this.user = user;
        this.notification = notification;
        this.deleteFlag = deleteFlag;
        this.seen = seen;
    }

    public UserNotification(User user, Notification notification, boolean deleteFlag, boolean seen) {
        this.user = user;
        this.notification = notification;
        this.deleteFlag = deleteFlag;
        this.seen = seen;
    }
}
