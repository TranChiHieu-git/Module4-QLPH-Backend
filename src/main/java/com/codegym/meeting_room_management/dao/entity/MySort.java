package com.codegym.meeting_room_management.dao.entity;

import org.springframework.data.domain.Sort;

public class MySort {

String active;
String direction;

    public MySort(String active, String direction) {
        this.active = active;
        this.direction = direction;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    public Sort getSort(){
        if(this.getDirection().equals("asc")){
            return  Sort.by(Sort.Direction.ASC, "notification."+ this.getActive());
        }else if(this.getDirection().equals("desc")){
            return Sort.by(Sort.Direction.DESC, "notification."+ this.getActive());
        }else{
            return Sort.by(Sort.DEFAULT_DIRECTION, "id");
        }
    }
}

