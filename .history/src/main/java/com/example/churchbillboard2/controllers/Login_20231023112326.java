package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Login {

    private UserService userService;
    private TimeManager timeManager;

    public Login(UserService userService, TimeManager timeManager) {
        this.userService = userService;
        this.timeManager = timeManager;
    }

    @GetMapping(value="/")
    public String getHome() {
        return "Hi From Home";
    }
    
    
    @PostMapping(value="/login")
    public SessionToken getMethodName(@RequestBody LoginDTO user) {
        return (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User") : new SessionToken(null);
    }

    @PostMapping(value="/months")
    public AvailableMonthsWrapper getMethodName(@RequestHeader("Authorization") String headerValue, @RequestBody LoginDTO user) {
        System.out.println(headerValue);
        return new AvailableMonthsWrapper(timeManager.availableMonths());
    }
    
}
