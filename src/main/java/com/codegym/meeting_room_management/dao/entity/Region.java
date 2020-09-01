package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "region")
public class Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int idRegion;
    @Column(name = "name")
    private String regionName;
    @OneToMany(mappedBy = "region")
    private List<Room> roomList;

    public Region() {
    }

    public Region(int idRegion, String regionName, List<Room> roomList) {
        this.idRegion = idRegion;
        this.regionName = regionName;
        this.roomList = roomList;
    }

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

}
