package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Region;
import com.codegym.meeting_room_management.dao.repository.RegionRepository;
import com.codegym.meeting_room_management.service.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    RegionRepository regionRepository;

    @Override
    public List<Region> findList() {
        return regionRepository.findAll();
    }
}
