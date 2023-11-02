package com.example.churchbillboard2.models;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;  // You mentioned it's returned as a Long
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(Object[] result) {
        this.id = (Long) result[0];
        this.familyEventDate = (Long) result[1];
        this.family = (String) result[2];
        this.familyEventTypeId = (String) result[3];
    }

    // Getters and setters (optional)
}
