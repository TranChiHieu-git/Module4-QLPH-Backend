package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.User;

public interface UserService {
    User findById(int id);
}
