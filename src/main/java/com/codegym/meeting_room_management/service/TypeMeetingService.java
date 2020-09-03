package com.codegym.meeting_room_management.service;

import com.codegym.meeting_room_management.dao.entity.TypeMeeting;

import java.util.List;

public interface TypeMeetingService {
    List<TypeMeeting> findList();
}
