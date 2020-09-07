package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.User;
import com.codegym.meeting_room_management.dao.repository.UserRepository;
import com.codegym.meeting_room_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Override
    public User findById(int id) {
        return userRepository.findById(id).orElse(null);
    }
}
