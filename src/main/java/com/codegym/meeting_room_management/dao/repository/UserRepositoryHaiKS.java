package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryHaiKS extends JpaRepository<User, Integer> {
    User findAllByUsername(String name);
}