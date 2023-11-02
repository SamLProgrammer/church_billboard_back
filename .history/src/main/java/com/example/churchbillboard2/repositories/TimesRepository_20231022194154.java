package com.example.churchbillboard2.repositories;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

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
    
}
