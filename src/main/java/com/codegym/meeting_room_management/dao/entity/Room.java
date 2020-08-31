package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room_asset")
public class Room {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "area")
    private float area;
    @Column(name = "floor")
    private int floor;
    @Column(name = "capacity")
    private int capacity;
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

    public Room(String name, float area, int floor, int capacity, boolean deleteFlag, TypeRoom typeRoom,
                Region region, Status status) {
        this.name = name;
        this.area = area;
        this.floor = floor;
        this.capacity = capacity;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
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
