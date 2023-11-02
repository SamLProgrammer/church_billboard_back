package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.springframework.stereotype.Service;

import com.example.churchbillboard2.repositories.TimesRepository;

@Service
public class TimeManager {

    public Date getCurrentTime() {

        String timeZoneId = "America/Bogota";
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        Date currentTime = calendar.getTime();
        int[] timeData = new int[6];

        timeData[0] = calendar.get(Calendar.YEAR);
        timeData[1] = calendar.get(Calendar.MONTH) + 1;
        timeData[2] = calendar.get(Calendar.DAY_OF_MONTH);
        timeData[3] = calendar.get(Calendar.YEAR);
        timeData[4] = calendar.get(Calendar.YEAR);
        timeData[5] = calendar.get(Calendar.YEAR);

        return currentTime;
    }

    public String[] availableMonths(int currentMonth) {

        int index = 0;
        String[] monthsList = new String[(currentMonth != 11) ? currentMonth+1 : currentMonth];

        while(index < monthsList.length) {
            monthsList[index] = TimesRepository.monthsMap.get(index);
            index++;
        }

        return monthsList;
    }
}