package com.example.churchbillboard2.DTOs;

import java.util.Date;
import java.util.List;

public class MonthFamilyEventsWrapper {

    private List<FamilyEventDTO> supperList;
    private List<FamilyEventDTO> snackList;
    private List<Date> sundaysList;
    private String error;

    public MonthFamilyEventsWrapper(String error) {
        this.error = error;
    }

    public MonthFamilyEventsWrapper(List<FamilyEventDTO> supperList, List<FamilyEventDTO> snackList) {
        this.supperList = supperList;
        this.snackList = snackList;
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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public List<Date> getSundaysList() {
        return sundaysList;
    }

    public void setSundaysList(List<Date> sundaysList) {
        this.sundaysList = sundaysList;
    }
}
