package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Region;

import java.util.List;

public interface RegionService {
    List<Region> findList();
}
