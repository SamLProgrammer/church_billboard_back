package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.SessionScope;
import com.example.churchbillboard2.security.SessionToken;
import com.example.churchbillboard2.services.TimeManager;
import com.example.churchbillboard2.services.UserService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.servlet.http.HttpSession;

import java.util.ArrayList;

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
    private SessionTokenWrapper sessionTokenWrapper;
    private final ShoppingCart shoppingCart;

    public Login(UserService userService, TimeManager timeManager, SessionTokenWrapper sessionTokenWrapper, ShoppingCart shoppingCart) {
        this.userService = userService;
        this.timeManager = timeManager;
        this.sessionTokenWrapper = sessionTokenWrapper;
        this.shoppingCart = shoppingCart;
    }

    @GetMapping(value="/")
    public String getHome() {
        return "Hi From Home";
    }
    
    
    @PostMapping(value="/login")
    public SessionToken getMethodName(@RequestBody LoginDTO user, HttpSession session) {
        String sessionId = (String) session.getAttribute("sessionId");
        System.out.println("sessionId: " + sessionId);
        SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User") : new SessionToken(null);
        sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
        return sessionToken;
    }

    @PostMapping(value="/months")
    public AvailableMonthsWrapper getMethodName(@RequestHeader("Authorization") String headerValue, HttpSession session) {
        String sessionId = (String) session.getAttribute("sessionId");
        System.out.println("sessionId: " + sessionId);
        return (sessionTokenWrapper.validateToken(headerValue)) ? new AvailableMonthsWrapper(timeManager.availableMonths()) : new AvailableMonthsWrapper("Not Valid Session");
    }

    @PostMapping("/add")
    public String addItem(@RequestBody String item, HttpSession session) {
        // session.setAttribute("testAttribute", "TestValue"); // Create a test attribute
        System.out.println("/add");
        System.out.println(session.getId());
        shoppingCart.addItem(item);
        return "Item added to the cart: " + item;
    }

    @GetMapping("/items")
    public ArrayList<String> getItems() {
        return shoppingCart.getItems();
    }

    @PostConstruct
    public void postc() {
        System.out.println("LoginController: I was created");
    }

    @PreDestroy
    public void preD() {
        System.out.println("LoginController: I was deleted");
    }

    
}
