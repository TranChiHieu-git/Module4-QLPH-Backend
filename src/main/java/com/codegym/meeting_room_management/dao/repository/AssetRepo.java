package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Asset;
import com.codegym.meeting_room_management.dao.entity.MeetingRoomAsset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepo extends JpaRepository<Asset, Integer> {
    @Query(value = "SELECT Asset.id, Asset.name, Asset.number_using, Asset.number_fixed, Asset.number_availability," +
            "Asset.total, Asset.detail, Asset.price, Asset.img, Asset.delete_flag FROM " +
            "Asset left join meeting_room_asset " +
            "on meeting_room_asset.id_asset = asset.id WHERE "+
            "(meeting_room_asset.id_room = ?1 AND Asset.delete_flag = 0);",
            nativeQuery = true)
    List<Asset> findAllByRoom_Id(int id);
}
