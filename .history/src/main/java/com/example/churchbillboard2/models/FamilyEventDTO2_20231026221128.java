package com.example.churchbillboard2.models;

import java.sql.Timestamp;

public class FamilyEventDTO2 {
    private Long id;
    private Timestamp familyEventDate;
    private String family;
    private Character familyEventTypeId;


    public FamilyEventDTO2(Long id, Timestamp familyEventDate, String family, Character familyEventTypeId) {
        this.id = id;
        this.familyEventDate = familyEventDate;
        this.family = family;
        this.familyEventTypeId = familyEventTypeId;
    }

    public FamilyEventDTO2() {
        
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setFamilyEventDate(Timestamp familyEventDate) {
        this.familyEventDate = familyEventDate;
    }

    public void setFamilyEventTypeId(Character familyEventTypeId) {
        this.familyEventTypeId = familyEventTypeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public Timestamp getFamilyEventDate() {
        return familyEventDate;
    }

    public Long getId() {
        return id;
    }

    public Character getFamilyEventTypeId() {
        return familyEventTypeId;
    }

}
