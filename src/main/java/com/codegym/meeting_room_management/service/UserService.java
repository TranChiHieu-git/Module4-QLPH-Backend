package com.codegym.meeting_room_management.service;


import com.codegym.meeting_room_management.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    Page<User> findAllUserByDeleteFlagIsFalse(Pageable pageable);

    User findGetId(int id);

    User findUserByAccountName(String username);

    void save (User user);

    void remove(int id);

    List<User> getListAllUser();

}