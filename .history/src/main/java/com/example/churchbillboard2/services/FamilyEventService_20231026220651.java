package com.example.churchbillboard2.services;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

import org.springframework.stereotype.Service;

import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.models.FamilyEventDTO;
import com.example.churchbillboard2.models.FamilyEventDTO2;
import com.example.churchbillboard2.repositories.FamilyEventRepository;

@Service
public class FamilyEventService {

    private FamilyEventRepository familyEventRepository;

    public FamilyEventService(FamilyEventRepository familyEventRepository) {
        this.familyEventRepository = familyEventRepository;
    }

    public ArrayList<FamilyEventDTO2> getFamilyEventsByDateWithEventType(int month) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        String timeZoneId = "America/Bogota";
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        int year = calendar.get(Calendar.YEAR);

        Date firstDayOfMonth = firstDayOfMonth(month, year);
        Date lastDayOfMonth = lastDayOfMonth(month, year);

        return belowGetFamilyEventsByDateWithEventType(sdf.format(firstDayOfMonth), sdf.format(lastDayOfMonth));
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

    private ArrayList<Object> belowGetFamilyEventsByDateWithEventType(String startDate, String endDate) {
        return familyEventRepository.getFamilyEventsBetween(startDate, endDate);
    }

    // private ArrayList<FamilyEventDTO> belowGetFamilyEventsByDateWithEventType(String startDate, String endDate) {
    //     return parseQueryToFamilyEventDTOs(familyEventRepository.getFamilyEventsBetween(startDate, endDate));
    // }

    // private ArrayList<FamilyEventDTO2> parseQueryToFamilyEventDTOs(ArrayList<Object> results) {
    //     ArrayList<FamilyEventDTO> familyEventDTOs = new ArrayList<FamilyEventDTO>();
    //     for (Object result : results) {
    //         Object[] prasedResult = (Object[]) result;
    //         FamilyEventDTO dto = new FamilyEventDTO();
    //         dto.setId((Long) prasedResult[0]);
    //         java.sql.Timestamp timestamp = (java.sql.Timestamp) prasedResult[1];
    //         dto.setFamilyEventDate(timestamp.getTime()); // Convert to milliseconds
    //         dto.setFamily((String) prasedResult[2]);
    //         dto.setFamilyEventTypeId((Character) prasedResult[3]);
    //         familyEventDTOs.add(dto);
    //     }

    //     return familyEventDTOs;
    // }
}
