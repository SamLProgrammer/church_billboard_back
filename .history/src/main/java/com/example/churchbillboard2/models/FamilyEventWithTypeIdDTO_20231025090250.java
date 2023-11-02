package com.example.churchbillboard2.models;

public class FamilyEventWithTypeIdDTO {
    private Object id;
    private Object familyEventDate;
    private Object family;
    private Object familyEventTypeId;

    public FamilyEventWithTypeIdDTO(Object id, Object familyEventDate, Object family, Object familyEventTypeId) {
        this.id = id;
        this.familyEventDate = familyEventDate;
        this.family = family;
        this.familyEventTypeId = familyEventTypeId;
    }

    // Getters and setters for the fields
}
