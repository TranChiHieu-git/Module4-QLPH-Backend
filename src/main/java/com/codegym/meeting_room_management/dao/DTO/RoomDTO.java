package com.codegym.meeting_room_management.dao.DTO;

public class RoomDTO {
    private int id;
    private String name;
    private int floor;
    private int capacity;
    private float area;
    private String asset;

    public RoomDTO() {
    }

    public RoomDTO(int id, String name, int floor, int capacity, float area, String asset) {
        this.id = id;
        this.name = name;
        this.floor = floor;
        this.capacity = capacity;
        this.area = area;
        this.asset = asset;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }
}
