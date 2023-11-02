package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.churchbillboard2.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Login {

    @Autowired
    UserService userService;

    @GetMapping(value="/")
    public String getHome() {
        return "Hi From Home";
    }
    
    
    @GetMapping(value="/login")
    public String getMethodName(@RequestBody LoginDTO user) {
        return (userService.getUserByUserName(user) == null) ? "User Validated" : "Invalid Login";
    }
    
}
