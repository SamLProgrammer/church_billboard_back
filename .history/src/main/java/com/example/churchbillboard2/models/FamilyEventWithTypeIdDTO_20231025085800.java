package com.example.churchbillboard2.models;

import java.util.Date;

import jakarta.persistence.Tuple;

public class FamilyEventWithTypeIdDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private Long familyEventTypeId;

    public FamilyEventWithTypeIdDTO(Tuple tuple) {
        this.id = tuple.get(0, Long.class);
        this.familyEventDate = tuple.get(1, Date.class);
        this.family = tuple.get(2, String.class);
        this.familyEventTypeId = tuple.get(3, Long.class);
    }

    // Getters and setters for the fields
}
