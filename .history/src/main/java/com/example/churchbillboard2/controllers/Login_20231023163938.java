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

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;




@RestController
@RequestMapping("/")
// @CrossOrigin(origins = "*")
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class Login {

    private ShoppingCart shoppingCart;
    
    public Login(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
    
    @PostMapping("/add")
    public String addItem(@RequestBody String item, HttpSession session) {
        System.out.println("/add");
        System.out.println(session.getId());
        shoppingCart.addItem(String.valueOf(Math.random()*100));
        return "Item added to the cart: " + item;
    }

    @GetMapping(value="/add")
    public String addItemGet(HttpSession session) {
        System.out.println("/add");
        System.out.println(session.getId());
        shoppingCart.addItem(String.valueOf(Math.random()*100));
        return "Item added to the cart";
    }
    
    @GetMapping("/items")
    public ArrayList<String> getItems(HttpSession session) {
        System.out.println("/items");
        System.out.println(session.getId());
        return shoppingCart.getItems();
    }
    
    
    
    
    @GetMapping(value="/")
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

// private UserService userService;
// private TimeManager timeManager;
// private SessionTokenWrapper sessionTokenWrapper;
// @PostMapping(value="/login")
// public SessionToken getMethodName(@RequestBody LoginDTO user, HttpSession session) {
    //     SessionToken sessionToken = (userService.getUserByUserName(user) == null) ? new SessionToken("Invalid User") : new SessionToken(null);
    //     sessionTokenWrapper.setSessionToken(sessionToken.getSessionToken());
    //     return sessionToken;
    // }
    
    // @PostMapping(value="/months")
    // public AvailableMonthsWrapper getMethodName(@RequestHeader("Authorization") String headerValue, HttpSession session) {
        //     return (sessionTokenWrapper.validateToken(headerValue)) ? new AvailableMonthsWrapper(timeManager.availableMonths()) : new AvailableMonthsWrapper("Not Valid Session");
        // }
        // public Login(UserService userService, TimeManager timeManager, SessionTokenWrapper sessionTokenWrapper, ShoppingCart shoppingCart) {
        //     this.userService = userService;
        //     this.timeManager = timeManager;
        //     this.sessionTokenWrapper = sessionTokenWrapper;
        //     this.shoppingCart = shoppingCart;
        // }