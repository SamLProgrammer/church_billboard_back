package com.example.churchbillboard2.models;

import jakarta.persistence.Tuple;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(Tuple tuple) {
        System.out.println("'tubili'");
        System.out.println(tuple);
        this.id = tuple.get("id", Long.class);
        this.familyEventDate = tuple.get("family_event_date", Long.class);
        this.family = tuple.get("family", String.class);
        this.familyEventTypeId = tuple.get("familyEventTypeId", String.class);
    }

    public String getFamily() {
        return family;
    }

    public Long getFamilyEventDate() {
        return familyEventDate;
    }

    public String getFamilyEventTypeId() {
        return familyEventTypeId;
    }

    public Long getId() {
        return id;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setFamilyEventDate(Long familyEventDate) {
        this.familyEventDate = familyEventDate;
    }

    public void setFamilyEventTypeId(String familyEventTypeId) {
        this.familyEventTypeId = familyEventTypeId;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
