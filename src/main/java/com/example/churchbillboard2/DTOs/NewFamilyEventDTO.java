package com.example.churchbillboard2.DTOs;

public class NewFamilyEventDTO {

    private String date;
    private String family;
    private Character type;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Character getType() {
        return type;
    }
    public void setType(Character type) {
        this.type = type;
    }
}
