package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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

    public String availableMonths(int currentMonth) {
        Map<Integer, String> monthsMap = new HashMap<>();
        
        monthsMap.put(1, "Enero");
        monthsMap.put(2, "Febrero");
        monthsMap.put(3, "Marzo");
        monthsMap.put(4, "Abril");
        monthsMap.put(5, "Mayo");
        monthsMap.put(6, "Junio");
        monthsMap.put(7, "Julio");
        monthsMap.put(8, "Agosto");
        monthsMap.put(9, "Septiembre");
        monthsMap.put(10, "Octubre");
        monthsMap.put(11, "Noviembre");
        monthsMap.put(12, "Diciember");
    }
}