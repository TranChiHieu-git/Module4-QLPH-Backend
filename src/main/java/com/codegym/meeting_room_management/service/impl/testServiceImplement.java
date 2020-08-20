package com.codegym.meeting_room_management.service.impl;

import com.codegym.meeting_room_management.dao.entity.test;
import com.codegym.meeting_room_management.dao.repository.testRepository;
import com.codegym.meeting_room_management.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class testServiceImplement implements testService {
    @Autowired
    testRepository testRepository;

    @Override
    public List<test> findAll() {
        return testRepository.findAll();
    }
}
