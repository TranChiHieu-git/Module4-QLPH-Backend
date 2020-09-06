package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {
}
