package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeManager {

    public Date getCurrentTime() {
        String timeZoneId = "America/Bogota";
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        Date currentTime = calendar.getTime();
        
        return currentTime;
    }
}