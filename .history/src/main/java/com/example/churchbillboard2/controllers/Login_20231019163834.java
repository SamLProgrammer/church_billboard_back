package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class Login {

    @GetMapping(value="/")
    public String getHome() {
        return "Hi From Home";
    }
    
    
    @GetMapping(value="/login")
    public String getMethodName() {
        return "Hi From Login";
    }
    
}
