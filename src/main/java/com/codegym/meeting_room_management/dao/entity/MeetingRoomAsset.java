//package com.codegym.meeting_room_management.dao.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "meeting_room_assat")
//public class MeetingRoomAsset {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_room")
//    private int idRoom;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id_asset")
//    private int idAsset;
//    @Column(name = "quantity_user")
//    private int quantityUser;
//
//    public MeetingRoomAsset() {
//    }
//
//    public MeetingRoomAsset(int idRoom, int idAsset, int quantityUser) {
//        this.idRoom = idRoom;
//        this.idAsset = idAsset;
//        this.quantityUser = quantityUser;
//    }
//
//    public int getIdRoom() {
//        return idRoom;
//    }
//
//    public void setIdRoom(int idRoom) {
//        this.idRoom = idRoom;
//    }
//
//    public int getIdAsset() {
//        return idAsset;
//    }
//
//    public void setIdAsset(int idAsset) {
//        this.idAsset = idAsset;
//    }
//
//    public int getQuantityUser() {
//        return quantityUser;
//    }
//
//    public void setQuantityUser(int quantityUser) {
//        this.quantityUser = quantityUser;
//    }
//}
