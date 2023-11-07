package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.example.churchbillboard2.DTOs.AvailableMonthsWrapper;
import com.example.churchbillboard2.DTOs.LoginDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.DTOs.NewFamilyEventDTO;
import com.example.churchbillboard2.DTOs.SessionTokenWrapper;
import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.FamilyEventService;
import com.example.churchbillboard2.services.InsertResult;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
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
        return new AvailableMonthsWrapper(timeManager.availableMonths());
    }

    @PostMapping(value = "/monthData")
    public MonthFamilyEventsWrapper postMethodName(@RequestBody String month) {
        return familyEventService.getFamilyEventsByDateWithEventType(month);
    }

    @GetMapping(value = "/")
    public String getHome(HttpSession session) {
        return "Im alive";
    }

    @PostMapping(value = "/addFamilyEvent")
    public InsertResult postMethodName(@RequestBody ArrayList<NewFamilyEventDTO> newFamilyEventsList) {
        return familyEventService.insertFamilyEvents(newFamilyEventsList);
    }
}
