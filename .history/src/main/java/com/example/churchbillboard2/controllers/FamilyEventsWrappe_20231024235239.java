package com.example.churchbillboard2.controllers;

import java.util.ArrayList;

import com.example.churchbillboard2.models.FamilyEvent;

public class FamilyEventsWrappe {
    
    private ArrayList<FamilyEvent> familyEvents;

    private String error;

    public String getError() {
        return error;
    }
    public ArrayList<FamilyEvent> getFamilyEvents() {
        return familyEvents;
    }
    public void setError(String error) {
        this.error = error;
    }
    public void setFamilyEvents(ArrayList<FamilyEvent> familyEvents) {
        this.familyEvents = familyEvents;
    }
}
