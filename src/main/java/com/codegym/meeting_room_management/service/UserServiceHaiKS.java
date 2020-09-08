package com.codegym.meeting_room_management.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserServiceHaiKS {
    UserDetails loadAccountByAccountName(String accountName);
}