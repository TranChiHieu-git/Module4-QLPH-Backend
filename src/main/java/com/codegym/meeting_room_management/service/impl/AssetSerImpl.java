package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Asset;
import com.codegym.meeting_room_management.dao.repository.AssetRepo;
import com.codegym.meeting_room_management.service.AssetSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetSerImpl implements AssetSer {
    @Autowired
    AssetRepo assetRepo;

    @Override
    public String assetSer(int id) {
        String result = "";
        List<Asset> listAsset = assetRepo.findAllByRoom_Id(id);
        for (int i = 0; i < listAsset.size(); i++) {
            if (result != "") {
                result += ", " + listAsset.get(i).getName();
            } else {
                result += listAsset.get(i).getName();
            }
        }
        return result;
    }

    @Override
    public String assetSerId(int id) {
        String result = "";
        List<Asset> listAsset = assetRepo.findAllByRoom_Id(id);
        for (int i = 0; i < listAsset.size(); i++) {
            if (result != "") {
                result += ", " + listAsset.get(i).getId();
            } else {
                result += listAsset.get(i).getId();
            }
        }
        return result;
    }
}
