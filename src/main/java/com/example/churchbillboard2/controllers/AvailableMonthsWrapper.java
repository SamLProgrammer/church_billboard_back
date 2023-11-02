package com.example.churchbillboard2.controllers;

public class AvailableMonthsWrapper {

    private String[] availableMonths;
    private String error;

    public AvailableMonthsWrapper(String[] availableMonths) {
        this.availableMonths = availableMonths;
    }

    public AvailableMonthsWrapper(String error) {
        this.error = error;
    }

    public String[] getAvailableMonths() {
        return availableMonths;
    }

    public String getError() {
        return error;
    }

}
