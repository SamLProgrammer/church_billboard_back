package com.example.churchbillboard2.models;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeManager {



    public String getCurrentTime() {
        String timeZoneId = "America/Bogota";
        
        ZonedDateTime currentTime = ZonedDateTime.now(ZoneId.of(timeZoneId));
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        
        System.out.println("Current time in Bogotá, Colombia: " + formattedTime);
        return formattedTime;
    }
}