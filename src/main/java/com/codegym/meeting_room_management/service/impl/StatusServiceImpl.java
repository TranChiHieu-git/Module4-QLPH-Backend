package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.Status;
import com.codegym.meeting_room_management.dao.repository.StatusRepository;
import com.codegym.meeting_room_management.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<Status> findList() {
        return statusRepository.findAll();
    }
}
