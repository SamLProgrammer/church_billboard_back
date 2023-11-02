package com.example.churchbillboard2.models;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public class TimeManager {

    private static Map<Integer, String> monthsMap = new HashMap<>();

    static {
        monthsMap.put(0, "Enero");
        monthsMap.put(1, "Febrero");
        monthsMap.put(2, "Marzo");
        monthsMap.put(3, "Abril");
        monthsMap.put(4, "Mayo");
        monthsMap.put(5, "Junio");
        monthsMap.put(6, "Julio");
        monthsMap.put(7, "Agosto");
        monthsMap.put(8, "Septiembre");
        monthsMap.put(9, "Octubre");
        monthsMap.put(10, "Noviembre");
        monthsMap.put(11, "Diciembre");
    }

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
            monthsList[index] = monthsMap.get(index);
            index++;
        }

        return monthsList;
    }
}