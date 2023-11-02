package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.churchbillboard2.security.SessionToken;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@RequestScope
public class AvailableMonthsWrapper {

    private String[] availableMonths;

    public AvailableMonthsWrapper(String[] availableMonths) {
        this.availableMonths = availableMonths;
    }

    public String[] getAvailableMonths() {
        return availableMonths;
    }

}
