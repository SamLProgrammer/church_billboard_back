package com.example.churchbillboard2.services;

import java.util.ArrayList;
import java.util.Calendar;
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

    public ArrayList<FamilyEvent> getFamilyEventsByDateWithEventType(int month, int year) {
        return belowGetFamilyEventsByDateWithEventType(firstDayOfMonth(month, year), lastDayOfMonth(month, year));
    }

    private Date firstDayOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Months are 0-based in Calendar, so subtract 1
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        // Get the Date representing the first day of the specified month and year
        return calendar.getTime();
    }

    private Date lastDayOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1); // Months are 0-based in Calendar, so subtract 1
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        // Get the Date representing the last day of the specified month and year
        return calendar.getTime();
    }

    private ArrayList<FamilyEvent> belowGetFamilyEventsByDateWithEventType(Date startDate, Date endDate) {
        return familyEventRepository.findBetweenDatesWithEventType(startDate, endDate);
    }
}
