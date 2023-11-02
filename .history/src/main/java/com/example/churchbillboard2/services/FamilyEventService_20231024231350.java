package com.example.churchbillboard2.services;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.repositories.FamilyEventRepository;

@Service
public class FamilyEventService {

    private FamilyEventRepository familyEventRepository;

    public FamilyEventService(FamilyEventRepository familyEventRepository) {
        this.familyEventRepository = familyEventRepository;
    }

    public ArrayList<FamilyEvent> getFamilyEventsByDateWithEventType(Date date) {
        return familyEventRepository.findBetweenDatesWithEventType(date);
    }
}
