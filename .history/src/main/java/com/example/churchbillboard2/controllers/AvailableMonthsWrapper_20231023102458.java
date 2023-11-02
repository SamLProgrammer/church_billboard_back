package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import com.example.churchbillboard2.security.SessionToken;

@Component
@RequestScope
public class AvailableMonthsWrapper {

    private String[] availableMonths;
    private String error;
    private SessionToken sessionToken;

    public AvailableMonthsWrapper(String[] availableMonths, String error, SessionToken sessionToken) {
        this.availableMonths = availableMonths;
        this.error = error;
        this.sessionToken = sessionToken;
    }

    public String[] getAvailableMonths() {
        return availableMonths;
    }

    public String getError() {
        return error;
    }

}
