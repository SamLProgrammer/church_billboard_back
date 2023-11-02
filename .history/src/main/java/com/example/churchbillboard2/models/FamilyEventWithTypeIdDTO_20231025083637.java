package com.example.churchbillboard2.models;

import java.util.Date;

public class FamilyEventWithTypeIdDTO {
    private Long id;
    private Date familyEventDate;
    private String family;
    private Long familyEventTypeId;

    public FamilyEventWithTypeIdDTO(Long id, Date familyEventDate, String family, Long familyEventTypeId) {
        this.id = id;
        this.familyEventDate = familyEventDate;
        this.family = family;
        this.familyEventTypeId = familyEventTypeId;
    }

    // Getters and setters for the fields
}
