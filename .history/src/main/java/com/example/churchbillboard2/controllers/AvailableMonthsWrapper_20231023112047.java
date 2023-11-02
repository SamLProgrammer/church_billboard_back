package com.example.churchbillboard2.controllers;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

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
