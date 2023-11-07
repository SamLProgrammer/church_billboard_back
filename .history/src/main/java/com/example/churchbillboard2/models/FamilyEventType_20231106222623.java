package com.example.churchbillboard2.models;

import org.hibernate.type.descriptor.jdbc.JdbcTypeFamilyInformation.Family;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "family_event_types")
public class FamilyEventType {

    @Id
    private char id;

    @Column(name = "family_event_type")
    private String familyEventType;

    public FamilyEventType() {}

    public FamilyEventType(char id, String familyEventType) {
        this.id = id;
    }


    public String getFamilyEventType() {
        return familyEventType;
    }

    public char getId() {
        return id;
    }
    
}
