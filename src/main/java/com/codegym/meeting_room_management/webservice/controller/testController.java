package com.codegym.meeting_room_management.webservice.controller;

import com.codegym.meeting_room_management.dao.entity.test;
import com.codegym.meeting_room_management.service.testService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class testController {
    @Autowired
    testService testService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloPage() {
        return "Xin chào C0220G1";
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public ResponseEntity<List<test>> listTest() {
        List<test> tests = testService.findAll();
        return tests.isEmpty() ? new ResponseEntity<>(HttpStatus.NO_CONTENT) : new ResponseEntity<>(tests, HttpStatus.OK);
    }
}
