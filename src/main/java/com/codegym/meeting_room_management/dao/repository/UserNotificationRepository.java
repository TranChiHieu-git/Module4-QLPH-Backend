package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Integer> {

@Query(value = "select u from UserNotification u where u.user.id= ?1")
    List<UserNotification> findAllByUserId( int id);

}
