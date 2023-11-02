package com.example.churchbillboard2.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import com.example.churchbillboard2.DTOs.FamilyEventDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.repositories.FamilyEventRepository;
import com.example.churchbillboard2.repositories.TimesRepository;

@Service
public class FamilyEventService {

    private FamilyEventRepository familyEventRepository;

    public FamilyEventService(FamilyEventRepository familyEventRepository) {
        this.familyEventRepository = familyEventRepository;
    }

    public MonthFamilyEventsWrapper getFamilyEventsByDateWithEventType(String monthString) {

        int month = TimesRepository.stringMonthsMap.get(monthString);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date firstDayOfMonth = firstDayOfMonth(month);
        Date lastDayOfMonth = lastDayOfMonth(month);

        return belowGetFamilyEventsByDateWithEventType(month, sdf.format(firstDayOfMonth), sdf.format(lastDayOfMonth));
    }

    private int getCurrentYear() {
        String timeZoneId = "America/Bogota";
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        return calendar.get(Calendar.YEAR);
    }

    private Date firstDayOfMonth(int month) {
        int year = getCurrentYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    private Date lastDayOfMonth(int month) {
        int year = getCurrentYear();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();
    }

    private MonthFamilyEventsWrapper belowGetFamilyEventsByDateWithEventType(int month, String startDate, String endDate) {

        MonthFamilyEventsWrapper monthFamilyEventsWrapper;
        ArrayList<FamilyEventDTO> queriedList = parseQueryToFamilyEventDTOs(familyEventRepository.getFamilyEventsBetween(startDate, endDate));
        ArrayList<Date> sundaysList = createSundaysListForMonth(month);
        if (queriedList.size() > 0) {
            List<FamilyEventDTO> supperList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'H')
                    .collect(Collectors.toList());

            List<FamilyEventDTO> snackList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'S')
                    .collect(Collectors.toList());
            monthFamilyEventsWrapper = new MonthFamilyEventsWrapper(sundaysList, supperList, snackList);
        } else {
            monthFamilyEventsWrapper = new MonthFamilyEventsWrapper(sundaysList, true);
        }

        return monthFamilyEventsWrapper;
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

    private ArrayList<Date> createSundaysListForMonth(int month) {
        System.out.println("month: " + month);
        ArrayList<Date> sundaysList = new ArrayList<>();

        Date firstDayOfMonth = firstDayOfMonth(month+1);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);
        System.out.println(calendar.get(Calendar.MONTH));

        Date lastDayOfMonth = lastDayOfMonth(month+1);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(lastDayOfMonth);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int sundayPivot = (8 - dayOfWeek) % 7;
        int cuttedDaysRange = calendar2.get(Calendar.DAY_OF_MONTH) - sundayPivot;

        do {
            calendar.set(Calendar.DAY_OF_MONTH, sundayPivot);
            System.out.println(calendar.getTime().toString());
            sundaysList.add(calendar.getTime());
            sundayPivot += 7;
        }while(sundayPivot <= cuttedDaysRange);

        return sundaysList;
    } 
}
