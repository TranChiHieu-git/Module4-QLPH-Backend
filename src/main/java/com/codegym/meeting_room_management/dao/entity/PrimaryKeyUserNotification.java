package com.codegym.meeting_room_management.dao.entity;


import javax.persistence.*;

import java.io.Serializable;

@Embeddable
public class PrimaryKeyUserNotification implements Serializable {
@ManyToOne
public User user;
@ManyToOne
public Notification notification;


    public Notification getNotification() {
        return notification;
    }

    public void setNotification(Notification notification) {
        this.notification = notification;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PrimaryKeyUserNotification() {
    }
}
