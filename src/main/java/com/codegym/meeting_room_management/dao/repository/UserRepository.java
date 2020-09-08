package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Page<User> findAllByDeleteFlagIsFalse(Pageable pageable);
    User findByUsername(String username);
    Page<User> findAllByUsernameContainingOrPositionOrFullName_AndDeleteFlagIsFalse(String key1, String key2, String key3, Pageable pageable);
}
