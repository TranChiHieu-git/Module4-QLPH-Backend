package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role,Integer> {
    Role findByRoleName(String name);

}
