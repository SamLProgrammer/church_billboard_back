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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
// @CrossOrigin(origins = "http://localhost:3000")
public class Login {

    private ShoppingCart shoppingCart;
    private UserService userService;
    private TimeManager timeManager;
    private SessionTokenWrapper sessionTokenWrapper;

    public Login(UserService userService, TimeManager timeManager, SessionTokenWrapper sessionTokenWrapper,
            ShoppingCart shoppingCart) {
        this.userService = userService;
        this.timeManager = timeManager;
        this.sessionTokenWrapper = sessionTokenWrapper;
        this.shoppingCart = shoppingCart;
    }

    @PostMapping(value = "/login")
    public SessionToken getMethodName(@RequestBody LoginDTO user, HttpSession session) {
        SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User")
                : new SessionToken(null);
        sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
        return sessionToken;
    }

    @GetMapping(value = "/months")
    public AvailableMonthsWrapper getMethodName(@RequestHeader("CustomAuth") String headerValue,
            HttpSession session) {
                System.out.println("headerValue");
                System.out.println(headerValue);
        return (sessionTokenWrapper.validateToken(headerValue))
                ? new AvailableMonthsWrapper(timeManager.availableMonths())
                : new AvailableMonthsWrapper("Not Valid Session");
    }

    @PostMapping("/add")
    public String addItem(@RequestBody String item, HttpSession session) {
        System.out.println("/add");
        System.out.println(session.getId());
        shoppingCart.addItem(String.valueOf(Math.random() * 100));
        return "Item added to the cart: " + item;
    }

    @GetMapping(value = "/add")
    public String addItemGet(HttpSession session) {
        System.out.println("/add");
        System.out.println(session.getId());
        shoppingCart.addItem(String.valueOf(Math.random() * 100));
        return "Item added to the cart";
    }

    @GetMapping("/items")
    public ArrayList<String> getItems(HttpSession session) {
        System.out.println("/items");
        System.out.println(session.getId());
        return shoppingCart.getItems();
    }

    @GetMapping(value = "/")
    public String getHome() {
        return "Hi From Home";
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
