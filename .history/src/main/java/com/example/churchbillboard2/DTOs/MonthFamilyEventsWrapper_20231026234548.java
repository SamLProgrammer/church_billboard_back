package com.example.churchbillboard2.DTOs;

import java.util.Date;
import java.util.List;

public class MonthFamilyEventsWrapper {

    private List<FamilyEventDTO> supperList;
    private List<FamilyEventDTO> snackList;
    private List<Date> sundaysList;
    private Boolean empty;

    public MonthFamilyEventsWrapper(Boolean empty) {
        this.empty = empty;
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

    public Boolean getEmpty() {
        return empty;
    }

    public void setEmpty(Boolean empty) {
        this.empty = empty;
    }

    public List<Date> getSundaysList() {
        return sundaysList;
    }

    public void setSundaysList(List<Date> sundaysList) {
        this.sundaysList = sundaysList;
    }
}
