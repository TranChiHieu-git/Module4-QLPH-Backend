package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String roomName;
    @Column(name = "area")
    private float roomArea;
    @Column(name = "floor")
    private int roomFloor;
    @Column(name = "capacity")
    private int roomCapacity;
    //        @Column(name = "number_of_uses")
//    private int numberOfUses;
    @Column(name = "delete_flag")
    private boolean deleteFlag;

    @ManyToOne
    @JoinColumn(name = "id_type_room")
    private TypeRoom typeRoom;
    @ManyToOne
    @JoinColumn(name = "id_region")
    private Region region;

    @ManyToOne
    @JoinColumn(name = "id_status")
    private Status status;

    public Room() {
    }

    public Room(int id, String roomName, float roomArea, int roomFloor, int roomCapacity,
                boolean deleteFlag, TypeRoom typeRoom, Region region, Status status) {
        this.id = id;
        this.roomName = roomName;
        this.roomArea = roomArea;
        this.roomFloor = roomFloor;
        this.roomCapacity = roomCapacity;
        this.deleteFlag = deleteFlag;
        this.typeRoom = typeRoom;
        this.region = region;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public float getRoomArea() {
        return roomArea;
    }

    public void setRoomArea(float roomArea) {
        this.roomArea = roomArea;
    }

    public int getRoomFloor() {
        return roomFloor;
    }

    public void setRoomFloor(int roomFloor) {
        this.roomFloor = roomFloor;
    }

    public int getRoomCapacity() {
        return roomCapacity;
    }

    public void setRoomCapacity(int roomCapacity) {
        this.roomCapacity = roomCapacity;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public TypeRoom getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(TypeRoom typeRoom) {
        this.typeRoom = typeRoom;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
