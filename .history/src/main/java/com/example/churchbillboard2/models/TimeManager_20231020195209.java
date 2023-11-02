package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeManager {

    public Date getCurrentTime() {
        String timeZoneId = "America/Bogota";
        
        // Create a Calendar instance with the specified time zone
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone(timeZoneId));
        
        // Get the current time as a Date object
        Date currentTime = calendar.getTime();
        
        return currentTime;
    }
}