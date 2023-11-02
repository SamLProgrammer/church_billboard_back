package com.example.churchbillboard2.DTOs;

import java.util.Date;

public class FamilyEventDTO {
    private Long id;
    private Date familyEventDate;
    private String family;
    private Character familyEventTypeId;

    public void setFamily(String family) {
        this.family = family;
    }

    public void setFamilyEventDate(Long familyEventDate) {
        this.familyEventDate = new Date(familyEventDate);
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

    public Date getFamilyEventDate() {
        return familyEventDate;
    }

    public Long getId() {
        return id;
    }

    public Character getFamilyEventTypeId() {
        return familyEventTypeId;
    }

}
