package com.example.churchbillboard2.services;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.churchbillboard2.DTOs.FamilyEventDTO;
import com.example.churchbillboard2.DTOs.MonthFamilyEventsWrapper;
import com.example.churchbillboard2.DTOs.NewFamilyEventDTO;
import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.models.FamilyEventType;
import com.example.churchbillboard2.repositories.FamilyEventRepository;
import com.example.churchbillboard2.repositories.TimesRepository;

@Service
public class FamilyEventService {

    private FamilyEventRepository familyEventRepository;

    public FamilyEventService(FamilyEventRepository familyEventRepository) {
        this.familyEventRepository = familyEventRepository;
    }

    @Transactional
    public InsertResult insertFamilyEvents(ArrayList<NewFamilyEventDTO> newFamilyEventDTOs) {
        InsertResult result = new InsertResult();
        ArrayList<FamilyEvent> familyEvents = parseDTOTosFamilyEvents(newFamilyEventDTOs);
        try {
            for (FamilyEvent familyEvent : familyEvents) {
                System.out.println("familyEvent.getFamilyEventDate()");
                System.out.println(familyEvent.getFamilyEventDate());
                FamilyEvent existingEvent = familyEventRepository.findByFamilyEventDateAndFamilyEventType(
                        familyEvent.getFamilyEventDate(), familyEvent.getFamilyEventType());

                if (existingEvent != null) {
                    existingEvent.setFamily(familyEvent.getFamily());
                    existingEvent.setFamilyEventType(familyEvent.getFamilyEventType());
                    familyEventRepository.save(existingEvent);
                } else {
                    familyEventRepository.save(familyEvent);
                }
            }
            result.setSuccess(true);
            result.setMessage("Operation was successful");
        } catch (Exception e) {
            result.setSuccess(false);
            result.setMessage("Operation failed: " + e.getMessage());
        }
        return result;
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
        calendar.set(year, month - 1, 1);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        return calendar.getTime();
    }

    private MonthFamilyEventsWrapper belowGetFamilyEventsByDateWithEventType(int month, String startDate,
            String endDate) {
        MonthFamilyEventsWrapper monthFamilyEventsWrapper;
        ArrayList<FamilyEventDTO> queriedList = parseQueryToFamilyEventDTOs(
                familyEventRepository.getFamilyEventsBetween(startDate, endDate));
        ArrayList<String> sundaysList = createSundaysListForMonth(month);

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

    private ArrayList<String> createSundaysListForMonth(int month) {
        ArrayList<String> sundaysList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date firstDayOfMonth = firstDayOfMonth(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);

        Date lastDayOfMonth = lastDayOfMonth(month);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(lastDayOfMonth);

        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int sundayPivot = ((8 - dayOfWeek) % 7) + dayOfMonth;
        int cuttedDaysRange = calendar2.get(Calendar.DAY_OF_MONTH) - sundayPivot;

        int sevenDivisor = 0;
        do {
            calendar.set(Calendar.DAY_OF_MONTH, sundayPivot);
            sundaysList.add(sdf.format(calendar.getTime()));
            sundayPivot += 7;
            sevenDivisor += 7;
        } while (sevenDivisor <= cuttedDaysRange);

        return sundaysList;
    }

    private ArrayList<FamilyEvent> parseDTOTosFamilyEvents(ArrayList<NewFamilyEventDTO> newFamilyEventDTOs) {
        ArrayList<FamilyEvent> familyEvents = new ArrayList<>();
        for (NewFamilyEventDTO newFamilyEventDTO : newFamilyEventDTOs) {
            familyEvents.add(parseDTOToFamilyEvent(newFamilyEventDTO));
        }
        return familyEvents;
    }

    private FamilyEvent parseDTOToFamilyEvent(NewFamilyEventDTO newFamilyEventDTO) {
        return new FamilyEvent(turnIntoDate(newFamilyEventDTO.getDate()), newFamilyEventDTO.getFamily(), new FamilyEventType(newFamilyEventDTO.getType()));
    }

    private Date turnIntoDate(String dateString) {
        LocalDate localDate = LocalDate.parse(dateString.substring(0, dateString.length()));
        ZoneId zone = ZoneId.of("UTC");
        return Date.from(localDate.atStartOfDay(zone).toInstant());
    }
}
