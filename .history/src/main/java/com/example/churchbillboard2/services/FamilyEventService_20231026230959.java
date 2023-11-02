package com.example.churchbillboard2.services;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.churchbillboard2.DTOs.FamilyEventDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEvents;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.repositories.FamilyEventRepository;
import com.example.churchbillboard2.repositories.TimesRepository;

@Service
public class FamilyEventService {

    private FamilyEventRepository familyEventRepository;

    public FamilyEventService(FamilyEventRepository familyEventRepository) {
        this.familyEventRepository = familyEventRepository;
    }

    public ArrayList<FamilyEventDTO> getFamilyEventsByDateWithEventType(String monthString) {

        int month = TimesRepository.stringMonthsMap.get(monthString);

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
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    private Date lastDayOfMonth(int month, int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();
    }

    private MonthFamilyEventsWrapper belowGetFamilyEventsByDateWithEventType(String startDate, String endDate) {

        ArrayList<FamilyEventDTO> queriedList = parseQueryToFamilyEventDTOs(
                familyEventRepository.getFamilyEventsBetween(startDate, endDate));

        MonthFamilyEventsWrapper monthFamilyEventsWrapper = new MonthFamilyEventsWrapper();

        if (queriedList.size() > 0) {
            List<FamilyEventDTO> supperList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'H')
                    .collect(Collectors.toList());

            List<FamilyEventDTO> snackList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'S')
                    .collect(Collectors.toList());
        }

        return parseQueryToFamilyEventDTOs(familyEventRepository.getFamilyEventsBetween(startDate, endDate));
    }

    private ArrayList<FamilyEventDTO> parseQueryToFamilyEventDTOs(ArrayList<Object> results) {
        ArrayList<FamilyEventDTO> familyEventDTOs = new ArrayList<FamilyEventDTO>();
        for (Object result : results) {
            Object[] prasedResult = (Object[]) result;
            FamilyEventDTO dto = new FamilyEventDTO();
            dto.setId((Long) prasedResult[0]);
            java.sql.Timestamp timestamp = (java.sql.Timestamp) prasedResult[1];
            dto.setFamilyEventDate(timestamp.getTime());
            dto.setFamily((String) prasedResult[2]);
            dto.setFamilyEventTypeId((Character) prasedResult[3]);
            familyEventDTOs.add(dto);
        }

        return familyEventDTOs;
    }
}
