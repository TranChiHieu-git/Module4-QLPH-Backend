package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Status;

import java.util.List;

public interface StatusService {
    List<Status> findList();
}
