package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_room")
public class TypeRoom {
    @Id
    @Column(name = "id_type_room")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeRoom;
    @Column(name = "name_type_room")
    private String nameTypeRoom;

    public TypeRoom() {
    }

    public TypeRoom(String nameTypeRoom) {
        this.nameTypeRoom = nameTypeRoom;
    }

    public int getIdTypeRoom() {
        return idTypeRoom;
    }

    public void setIdTypeRoom(int idTypeRoom) {
        this.idTypeRoom = idTypeRoom;
    }

    public String getNameTypeRoom() {
        return nameTypeRoom;
    }

    public void setNameTypeRoom(String nameTypeRoom) {
        this.nameTypeRoom = nameTypeRoom;
    }
}

