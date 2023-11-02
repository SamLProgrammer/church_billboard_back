package com.example.churchbillboard2.controllers;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/")
@CrossOrigin(origins = "*")
public class BillBoard {

    @GetMapping(value="/")
    public String getHome() {
        return "Hi From Home";
    }
    
    
    @GetMapping(value="/login")
    public ArrayList<String> getMethodName() {
        ArrayList<String> responseList = new ArrayList<>();
        responseList.add("Maya");
        responseList.add("Sam");
        responseList.add("Elengendro");
        return responseList;
    }
    
}
