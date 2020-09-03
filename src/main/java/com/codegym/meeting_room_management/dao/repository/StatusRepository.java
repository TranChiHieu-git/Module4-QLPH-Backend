package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
