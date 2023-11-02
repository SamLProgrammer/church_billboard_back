package com.example.churchbillboard2.repositories;

import java.util.HashMap;
import java.util.Map;

public class TimesRepository {

    public static Map<Integer, String> monthsMap = new HashMap<>();

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

    public static Map<String, Integer> stringMonthsMap = new HashMap<>();

    static {
        stringMonthsMap.put("Enero", 0);
        stringMonthsMap.put("Febrero", 1);
        stringMonthsMap.put("Marzo", 2);
        stringMonthsMap.put("Abril", 3);
        stringMonthsMap.put("Mayo", 4);
        stringMonthsMap.put("Junio", 5);
        stringMonthsMap.put("Julio", 6);
        stringMonthsMap.put("Agosto", 7);
        stringMonthsMap.put("Septiembre", 8);
        stringMonthsMap.put("Octubre", 9);
        stringMonthsMap.put("Noviembre", 10);
        stringMonthsMap.put("Diciembre", 11);
    }
    
}
