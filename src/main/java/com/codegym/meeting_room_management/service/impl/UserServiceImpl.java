package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.User;
import com.codegym.meeting_room_management.dao.repository.UserRepository;
import com.codegym.meeting_room_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable) {
        return userRepository.findAllByDeleteFlagIsFalse(pageable);
    }

    @Override
    public User findGetId(int id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findUserByAccountName(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void remove(int id) {
        User currentUser = findGetId(id);
        currentUser.setDeleteFlag(true);
        save(currentUser);
    }

    @Override
    public List<User> getListAllUser() {
        return userRepository.findAll();
    }
}
