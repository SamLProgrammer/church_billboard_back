package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

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

    public int[] availableMonths(int currentMonth) {
        
    }
}