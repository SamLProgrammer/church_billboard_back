package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.churchbillboard2.DTOs.AvailableMonthsWrapper;
import com.example.churchbillboard2.DTOs.LoginDTO;
import com.example.churchbillboard2.DTOs.NewFamilyEventDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.DTOs.SessionTokenWrapper;
import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.FamilyEventService;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

import org.springframework.dao.DataAccessException;
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
    public SessionToken getMethodName(@RequestBody LoginDTO user) {
        SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User")
                : new SessionToken(null);
        sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
        return sessionToken;
    }

    @PostMapping("/months")
    public AvailableMonthsWrapper getMethodName(HttpServletResponse response) {
        System.out.println("=======================================");
        System.out.println(sessionTokenWrapper.getSessionToken());
        return new AvailableMonthsWrapper(timeManager.availableMonths());
    }

    @PostMapping(value = "/monthData")
    public MonthFamilyEventsWrapper postMethodName(@RequestBody String month, HttpSession session) {
        System.out.println(session.getId());
        return familyEventService.getFamilyEventsByDateWithEventType(month);
    }

    @GetMapping(value = "/")
    public String getHome(HttpSession session) {
        return "Im alive";
    }

    @PostMapping(value = "/addFamilyEvent")
    public String postMethodName(@RequestBody ArrayList<NewFamilyEventDTO> xd) {
        for (NewFamilyEventDTO newFamilyEventDTO : xd) {
            System.out.println(newFamilyEventDTO.getDate() + "    " + newFamilyEventDTO.getFamily());
        }
        // }
        
        return "all nice";
    }
    // try {
    // usersRepository.insertUser("newUser", "password123");
    // // The insertion was successful
    // } catch (DataAccessException e) {
    // // An error occurred during insertion
    // e.printStackTrace();

}
