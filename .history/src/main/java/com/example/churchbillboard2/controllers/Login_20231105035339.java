package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;

import com.example.churchbillboard2.DTOs.LoginDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.FamilyEventService;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class Login {
    private UserService userService;
    private TimeManager timeManager;
    private SessionTokenWrapper sessionTokenWrapper;
    private FamilyEventService familyEventService;

    public Login(UserService userService, TimeManager timeManager,
            SessionTokenWrapper sessionTokenWrapper, FamilyEventService familyEventService) {
        this.userService = userService;
        this.timeManager = timeManager;
        this.sessionTokenWrapper = sessionTokenWrapper;
        this.familyEventService = familyEventService;
    }

    @PostMapping(value = "/login")
    public SessionToken getMethodName(@RequestBody LoginDTO user, HttpServletRequest request, HttpSession session) {
        String origin = request.getHeader("Origin");
        System.out.println("Origin: " + origin);
        System.out.println(session.getId());
        SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User")
                : new SessionToken(null);
        sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
        System.out.println(sessionToken.getSessionToken());
        return sessionToken;
    }

    // devop
    @PostMapping("/months")
    public AvailableMonthsWrapper getMethodName(HttpServletResponse response) {
        System.out.println(sessionTokenWrapper.getSessionToken());
        return new AvailableMonthsWrapper(timeManager.availableMonths());
    }
    // System.out.println("=================================");
    // System.out.println(headerValue);
    // System.out.println(session.getId());
    // return (sessionTokenWrapper.validateToken(headerValue))
    // ? new AvailableMonthsWrapper(timeManager.availableMonths())
    // : new AvailableMonthsWrapper("Not Valid Session");

    @PostMapping(value = "/monthData")
    public MonthFamilyEventsWrapper postMethodName(@RequestBody String month, HttpSession session) {
        System.out.println(session.getId());
        return familyEventService.getFamilyEventsByDateWithEventType(month);
    }

    // @PostMapping(value="/monthData")
    // public MonthFamilyEventsWrapper postMethodName(@RequestHeader("CustomAuth")
    // String headerValue, @RequestBody String month) {
    // return (sessionTokenWrapper.validateToken(headerValue)) ?
    // familyEventService.getFamilyEventsByDateWithEventType(month) : new
    // MonthFamilyEventsWrapper("Not Valid Session");
    // }

    @GetMapping(value = "/")
    public String getHome(HttpSession session) {
        return session.getId();
    }
}
