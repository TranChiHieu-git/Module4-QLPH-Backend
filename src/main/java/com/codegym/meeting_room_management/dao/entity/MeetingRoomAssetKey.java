package com.codegym.meeting_room_management.dao.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MeetingRoomAssetKey implements Serializable {
    @Column(name = "id_room")
    int idRoom;
    @Column(name = "id_asset")
    int idAsset;

    public MeetingRoomAssetKey() {
    }

    public int getIdRoom() {
        return idRoom;
    }

    public void setIdRoom(int idRoom) {
        this.idRoom = idRoom;
    }

    public int getIdAsset() {
        return idAsset;
    }

    public void setIdAsset(int idAsset) {
        this.idAsset = idAsset;
    }
}
