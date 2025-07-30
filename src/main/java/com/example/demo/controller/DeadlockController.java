package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.deadlock.DeadlockDetector;

@RestController
@RequestMapping("/deadlock")
public class DeadlockController {

    @Autowired
    private DeadlockDetector deadlockDetector;

    @GetMapping("/check")
    public String checkDeadlock() {
        return deadlockDetector.detectDeadlocks();
    }
}
