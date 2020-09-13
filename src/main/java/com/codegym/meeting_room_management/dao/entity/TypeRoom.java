package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "type_room")
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_room")
    private int idTypeRoom;
    @Column(name = "name_type_room")
    private String nameTypeRoom;
    @OneToMany(mappedBy = "typeRoom")
    private List<Room> roomList;

    public TypeRoom() {
    }

    public TypeRoom(int idTypeRoom, String nameTypeRoom, List<Room> roomList) {
        this.idTypeRoom = idTypeRoom;
        this.nameTypeRoom = nameTypeRoom;
        this.roomList = roomList;
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