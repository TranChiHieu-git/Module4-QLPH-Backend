package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "asset")
public class Asset {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "number_using")
    private int numberUsing;
    @Column(name = "number_fixed")
    private int numberFixed;
    @Column(name = "number_availability")
    private int numberAvailability;
    @Column(name = "total")
    private int total;
    @Column(name = "detail")
    private String detail;
    @Column(name = "price")
    private int price;
    @Column(name = "img")
    private String img;
    @Column(name = "delete_flag")
    private boolean deleteFlag;

    public Asset() {
    }

    public Asset(String name, int numberUsing, int numberFixed, int numberAvailability, int total, String detail, int price, String img, boolean deleteFlag) {
        this.name = name;
        this.numberUsing = numberUsing;
        this.numberFixed = numberFixed;
        this.numberAvailability = numberAvailability;
        this.total = total;
        this.detail = detail;
        this.price = price;
        this.img = img;
        this.deleteFlag = deleteFlag;
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

    public int getNumberUsing() {
        return numberUsing;
    }

    public void setNumberUsing(int numberUsing) {
        this.numberUsing = numberUsing;
    }

    public int getNumberFixed() {
        return numberFixed;
    }

    public void setNumberFixed(int numberFixed) {
        this.numberFixed = numberFixed;
    }

    public int getNumberAvailability() {
        return numberAvailability;
    }

    public void setNumberAvailability(int numberAvailability) {
        this.numberAvailability = numberAvailability;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(boolean deleteFlag) {
        this.deleteFlag = deleteFlag;
    }
}
