package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.TypeMeeting;
import com.codegym.meeting_room_management.dao.repository.TypeMeetingRepository;
import com.codegym.meeting_room_management.service.TypeMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeMeetingServiceImpl implements TypeMeetingService {
    @Autowired
    TypeMeetingRepository typeMeetingRepository;

    @Override
    public List<TypeMeeting> findList() {
        return typeMeetingRepository.findAll();
    }
}
