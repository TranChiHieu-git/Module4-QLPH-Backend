package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idStatus;
    @Column(name = "name")
    private String statusName;
    @OneToMany(mappedBy = "status")
    private List<Room> roomList;

    public Status() {
    }

    public Status(int idStatus, String statusName, List<Room> roomList) {
        this.idStatus = idStatus;
        this.statusName = statusName;
        this.roomList = roomList;
    }

    public int getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(int idRoomStatus) {
        this.idStatus = idRoomStatus;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

}
