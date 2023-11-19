package com.example.churchbillboard2.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.example.churchbillboard2.exceptions.CustomTransactionException;
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

    @Transactional(rollbackFor = Exception.class)
    public InsertResult insertFamilyEvents(ArrayList<NewFamilyEventDTO> newFamilyEventDTOs) {
        InsertResult result = new InsertResult();
        ArrayList<FamilyEvent> familyEvents = parseDTOTosFamilyEvents(newFamilyEventDTOs);
        try {
            for (FamilyEvent familyEvent : familyEvents) {
                if (familyEvent.getFamilyEventDate() == null) {
                    // If any date is null, throw a custom exception to trigger rollback
                    throw new CustomTransactionException(
                            "There is Something wrong with the date for: " + familyEvent.getFamily());
                }

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
        } catch (CustomTransactionException cte) {
            // Handle your custom exception
            result.setSuccess(false);
            result.setMessage("Operation failed: " + cte.getMessage());
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
        ArrayList<String> saturdaysList = createSaturdaysListForMonth(month);
        ArrayList<String> monthDaysList = createSpecificMonthDaysList(month);

        if (queriedList.size() > 0) {
            List<FamilyEventDTO> supperList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'H')
                    .collect(Collectors.toList());

            List<FamilyEventDTO> snackList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'S')
                    .collect(Collectors.toList());

            List<FamilyEventDTO> cleaningList = queriedList.stream()
                    .filter(n -> n.getFamilyEventTypeId() == 'C')
                    .collect(Collectors.toList());

            monthFamilyEventsWrapper = new MonthFamilyEventsWrapper(sundaysList, saturdaysList, monthDaysList, supperList, snackList, cleaningList);
        } else {
            monthFamilyEventsWrapper = new MonthFamilyEventsWrapper(sundaysList, saturdaysList, monthDaysList, true);
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

    private ArrayList<String> createSpecificMonthDaysList(int month) {
        ArrayList<String> daysList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date firstDayOfMonth = firstDayOfMonth(month);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(firstDayOfMonth);

        Date lastDayOfMonth = lastDayOfMonth(month);
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(lastDayOfMonth);

        int firstDayOfMonthInt = calendar.get(Calendar.DAY_OF_MONTH);
        int lastDayOfMonthInt = calendar2.get(Calendar.DAY_OF_MONTH);

        while(firstDayOfMonthInt < lastDayOfMonthInt) {
            daysList.add(sdf.format(calendar.getTime()));
            calendar.set(Calendar.DAY_OF_MONTH, firstDayOfMonthInt++);
        }

        return daysList;
    }
    private ArrayList<String> createSaturdaysListForMonth(int month) {
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
        int saturdayPivot = (7 - dayOfWeek) + dayOfMonth;
        int cuttedDaysRange = calendar2.get(Calendar.DAY_OF_MONTH) - saturdayPivot;

        int sevenDivisor = 0;
        do {
            calendar.set(Calendar.DAY_OF_MONTH, saturdayPivot);
            sundaysList.add(sdf.format(calendar.getTime()));
            System.out.println(sdf.format(calendar.getTime()));
            saturdayPivot += 7;
            sevenDivisor += 7;
        } while (sevenDivisor <= cuttedDaysRange);

        return sundaysList;
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
        return new FamilyEvent(turnIntoDate(newFamilyEventDTO.getDate()), newFamilyEventDTO.getFamily(),
                new FamilyEventType(newFamilyEventDTO.getType()));
    }

    private Date turnIntoDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = dateFormat.parse(dateString.substring(1, dateString.length() - 1));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
