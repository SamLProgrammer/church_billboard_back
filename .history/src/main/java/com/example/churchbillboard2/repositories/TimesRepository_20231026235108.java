package com.example.churchbillboard2.repositories;

import java.util.HashMap;
import java.util.Map;

public class TimesRepository {

    public static Map<Integer, String> monthsMap = new HashMap<>();

    static {
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
        monthsMap.put(12, "Diciembre");
    }

    public static Map<String, Integer> stringMonthsMap = new HashMap<>();

    static {
        stringMonthsMap.put("Enero", 1);
        stringMonthsMap.put("Febrero", 2);
        stringMonthsMap.put("Marzo", 3);
        stringMonthsMap.put("Abril", 4);
        stringMonthsMap.put("Mayo", 5);
        stringMonthsMap.put("Junio", 6);
        stringMonthsMap.put("Julio", 7);
        stringMonthsMap.put("Agosto", 8);
        stringMonthsMap.put("Septiembre", 9);
        stringMonthsMap.put("Octubre", 10);
        stringMonthsMap.put("Noviembre", 11);
        stringMonthsMap.put("Diciembre", 12);
    }
}
