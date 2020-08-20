package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface testRepository extends JpaRepository<test, Integer> {
}
