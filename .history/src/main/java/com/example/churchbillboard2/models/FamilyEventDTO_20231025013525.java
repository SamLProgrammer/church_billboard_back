package com.example.churchbillboard2.models;

import java.util.Date;

public class FamilyEventDTO {
    private Long familyEventId;
    private String familyEventDate;
    private String family;
    private Long familyEventTypeId;

    public FamilyEventDTO(Long familyEventId, String familyEventDate, String family, Long familyEventTypeId) {
        this.familyEventId = familyEventId;
        this.familyEventDate = familyEventDate;
        this.family = family;
        this.familyEventTypeId = familyEventTypeId;
    }

    // Getters and setters for the fields
}
