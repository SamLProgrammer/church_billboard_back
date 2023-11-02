package com.example.churchbillboard2.models;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "family_event_types")
public class FamilyEventType {
    @Basic(fetch = FetchType.LAZY)
    @Id
    private char id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "family_event_type")
    private String familyEventType;

    public String getFamilyEventType() {
        return familyEventType;
    }

    public char getId() {
        return id;
    }
    
}
