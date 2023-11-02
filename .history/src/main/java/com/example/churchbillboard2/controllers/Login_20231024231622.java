package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.RequestHeader;
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

    public Login(UserService userService, TimeManager timeManager, SessionTokenWrapper sessionTokenWrapper) {
        this.userService = userService;
        this.timeManager = timeManager;
        this.sessionTokenWrapper = sessionTokenWrapper;
    }

    @PostMapping(value = "/login")
    public SessionToken getMethodName(@RequestBody LoginDTO user, HttpSession session) {
        SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User")
                : new SessionToken(null);
        sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
        return sessionToken;
    }

    @PostMapping("/months")
    public AvailableMonthsWrapper getMethodName(@RequestHeader("CustomAuth") String headerValue,
            HttpSession session) {
        return (sessionTokenWrapper.validateToken(headerValue))
                ? new AvailableMonthsWrapper(timeManager.availableMonths())
                : new AvailableMonthsWrapper("Not Valid Session");
    }

    @GetMapping(value = "/")
    public String getHome() {
        return "Hi From Home";
    }
}
