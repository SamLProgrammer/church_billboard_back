package com.example.churchbillboard2.DTOs;

import java.util.List;

public class MonthFamilyEventsWrapper {

    private List<FamilyEventDTO> supperList;
    private List<FamilyEventDTO> snackList;
    private String error;

    public MonthFamilyEventsWrapper(String error) {
        this.error = error;
    }


    public MonthFamilyEventsWrapper(List<FamilyEventDTO> supperList, List<FamilyEventDTO> snackList) {
        this.supperList = supperList;
        this.snackList = snackList;
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
}
