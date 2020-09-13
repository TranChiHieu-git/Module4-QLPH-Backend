package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAllRole();
    Role findRoleById(int id);
    Role findRoleByRoleName(String name);
}
