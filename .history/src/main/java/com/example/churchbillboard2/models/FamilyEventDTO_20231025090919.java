package com.example.churchbillboard2.models;

import java.util.Date;

import jakarta.persistence.Tuple;

public class FamilyEventDTO {
    private Long id;
    private Date familyEventDate;
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(Tuple tuple) {
        this.id = tuple.get("id", Long.class);
        this.familyEventDate = new Date(tuple.get("family_event_date", Long.class));
        this.family = tuple.get("family", String.class);
        this.familyEventTypeId = tuple.get("familyEventTypeId", String.class);
    }

    // Getters and setters (optional)
}
