package com.example.churchbillboard2.services;
import java.util.Calendar;
import java.util.TimeZone;
import org.springframework.stereotype.Service;

import com.example.churchbillboard2.repositories.TimesRepository;

@Service
public class TimeManager {

    private int[] getCurrentTime() {

        String timeZoneId = "America/Bogota";
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        int[] timeData = new int[6];

        timeData[0] = calendar.get(Calendar.YEAR);
        timeData[1] = calendar.get(Calendar.MONTH) + 1;
        timeData[2] = calendar.get(Calendar.DAY_OF_MONTH);
        timeData[3] = calendar.get(Calendar.YEAR);
        timeData[4] = calendar.get(Calendar.YEAR);
        timeData[5] = calendar.get(Calendar.YEAR);

        return timeData;
    }

    private int getMonthFromDateArray(int[] dateArray) {
        return dateArray[1];
    }

    private String[] belowAvailableMonths(int currentMonth) {

        int index = 0;
        String[] monthsList = new String[(currentMonth != 11) ? currentMonth+1 : currentMonth];

        while(index < monthsList.length) {
            monthsList[index] = TimesRepository.monthsMap.get(index);
            index++;
        }

        return monthsList;
    }

    public String[] availableMonths() {
        return belowAvailableMonths(getMonthFromDateArray(getCurrentTime()));
    }
}