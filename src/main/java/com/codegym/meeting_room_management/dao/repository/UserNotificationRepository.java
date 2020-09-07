package com.codegym.meeting_room_management.dao.repository;

import com.codegym.meeting_room_management.dao.entity.UserNotification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserNotificationRepository extends JpaRepository<UserNotification, Integer> {

    @Query(value = "select u from UserNotification u where u.user.id= ?1")
    List<UserNotification> findAllByUserId(int id);

    @Modifying
    @Transactional
    @Query(value = "update UserNotification u set u.seen = true where u.id =?1")
    void markAsSeenById(int id);

    @Modifying
    @Transactional
    @Query(value = "update UserNotification u set u.deleteFlag=true where u.id =?1")
    void deleteById(int id);
    @Query(value = "select u from UserNotification u where u.user.id=?1 and u.deleteFlag = false")
    Page<UserNotification> getAllByUserIDDeleteFlagIsFalse(int id, Pageable pageable);

}
