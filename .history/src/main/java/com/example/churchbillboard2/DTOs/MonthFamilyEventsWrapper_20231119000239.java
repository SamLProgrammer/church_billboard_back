package com.example.churchbillboard2.DTOs;

import java.util.ArrayList;
import java.util.List;

public class MonthFamilyEventsWrapper {

    private List<FamilyEventDTO> supperList;
    private List<FamilyEventDTO> snackList;
    private List<FamilyEventDTO> cleaningList;
    private List<FamilyEventDTO> birthDaysList;
    private List<String> sundaysList;
    private List<String> saturdaysList;
    private List<String> monthDaysList;
    private Boolean empty;
    private String error;

    public MonthFamilyEventsWrapper(String error) {
        this.error = error;
    }

    public MonthFamilyEventsWrapper(ArrayList<String> sundaysList, ArrayList<String> saturdaysList, ArrayList<String> monthDaysList, Boolean empty) {
        this.sundaysList = sundaysList;
        this.saturdaysList = saturdaysList;
        this.monthDaysList = monthDaysList;
        this.empty = empty;
    }

    public MonthFamilyEventsWrapper(ArrayList<String> sundaysList, ArrayList<String> saturdaysList, ArrayList<String> monthDaysList, List<FamilyEventDTO> supperList,
            List<FamilyEventDTO> snackList, List<FamilyEventDTO> cleaningList, List<FamilyEventDTO> birthDaysList) {
        this.sundaysList = sundaysList;
        this.saturdaysList = saturdaysList;
        this.monthDaysList = monthDaysList;
        this.supperList = supperList;
        this.snackList = snackList;
        this.cleaningList = cleaningList;
        this.birthDaysList = birthDaysList;
    }

    public MonthFamilyEventsWrapper() {

    }

    public List<FamilyEventDTO> getSnackList() {
        return snackList;
    }

    public List<FamilyEventDTO> getSupperList() {
        return supperList;
    }

    public void setSnackList(List<FamilyEventDTO> snackList) {
        this.snackList = snackList;
    }

    public void setSupperList(List<FamilyEventDTO> supperList) {
        this.supperList = supperList;
    }

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public List<String> getSundaysList() {
        return sundaysList;
    }

    public void setSundaysList(List<String> sundaysList) {
        this.sundaysList = sundaysList;
    }

    public List<String> getSaturdaysList() {
        return saturdaysList;
    }

    public void setSaturdaysList(List<String> saturdaysList) {
        this.saturdaysList = saturdaysList;
    }

    public List<FamilyEventDTO> getCleaningList() {
        return cleaningList;
    }

    public void setCleaningList(List<FamilyEventDTO> cleaningList) {
        this.cleaningList = cleaningList;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
