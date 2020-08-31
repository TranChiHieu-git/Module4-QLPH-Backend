package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.*;

@Entity
@Table(name = "type_meeting")
public class TypeMeeting {
    @Id
    @Column(name = "id_type_meeting")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTypeMeeting;
    @Column(name = "name_type_meeting")
    private String nameTypeMeeting;

    public TypeMeeting() {
    }

    public TypeMeeting(String nameTypeMeeting) {
        this.nameTypeMeeting = nameTypeMeeting;
    }

    public int getIdTypeMeeting() {
        return idTypeMeeting;
    }

    public void setIdTypeMeeting(int idTypeMeeting) {
        this.idTypeMeeting = idTypeMeeting;
    }

    public String getNameTypeMeeting() {
        return nameTypeMeeting;
    }

    public void setNameTypeMeeting(String nameTypeMeeting) {
        this.nameTypeMeeting = nameTypeMeeting;
    }
}
