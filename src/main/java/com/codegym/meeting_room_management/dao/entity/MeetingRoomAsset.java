package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "meeting_room_assat")
public class MeetingRoomAsset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_room")
    private Room room;
    @ManyToOne
    @JoinColumn(name = "id_asset")
    private Asset asset;
    @Column(name = "quantity_user")
    private int quantityUser;

    public MeetingRoomAsset() {
    }

    public MeetingRoomAsset(Room room, Asset asset, int quantityUser) {
        this.room = room;
        this.asset = asset;
        this.quantityUser = quantityUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Asset getAsset() {
        return asset;
    }

    public void setAsset(Asset asset) {
        this.asset = asset;
    }

    public int getQuantityUser() {
        return quantityUser;
    }

    public void setQuantityUser(int quantityUser) {
        this.quantityUser = quantityUser;
    }
}
