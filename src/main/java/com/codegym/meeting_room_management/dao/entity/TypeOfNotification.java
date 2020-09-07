package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "type_of_notification")
public class TypeOfNotification {
@Id
   int id;
@Column(name = "type_of_notification_name")
String name;

    public TypeOfNotification() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
