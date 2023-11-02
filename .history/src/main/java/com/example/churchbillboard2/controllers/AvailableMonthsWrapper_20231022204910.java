package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class AvailableMonthsWrapper {
    
    private String[] availableMonths;
    private String error;


    public AvailableMonthsWrapper(String[] availableMonths, String error) {
        this.availableMonths = availableMonths;
        this.error = error;
    }
    
}
