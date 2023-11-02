package com.example.churchbillboard2.models;

public class FamilyEventWithTypeIdDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private Character familyEventTypeId;

    public FamilyEventWithTypeIdDTO(Long id, Long familyEventDate, String family, Long familyEventTypeId) {
        this.id = id;
        this.familyEventDate = familyEventDate;
        this.family = family;
        this.familyEventTypeId = familyEventTypeId;
    }

    // Getters and setters for the fields
}
