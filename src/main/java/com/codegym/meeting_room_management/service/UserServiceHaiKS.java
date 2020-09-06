package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.User;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserServiceHaiKS {
    UserDetails loadAccountByAccountName(String accountName);
}
