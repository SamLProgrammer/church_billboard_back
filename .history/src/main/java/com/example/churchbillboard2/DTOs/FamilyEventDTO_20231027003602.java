package com.example.churchbillboard2.DTOs;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FamilyEventDTO {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", timezone = "UTC")
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
