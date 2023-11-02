package com.example.churchbillboard2.models;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.ColumnResult;
import jakarta.persistence.ConstructorResult;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SqlResultSetMapping;
import jakarta.persistence.Table;

@Entity
@Table(name = "family_events")
@SqlResultSetMapping(
    name = "FamilyEventDTOMapping",
    classes = @ConstructorResult(
        targetClass = FamilyEventDTO2.class,
        columns = {
            @ColumnResult(name = "id", type = Long.class),
            @ColumnResult(name = "familyEventDate", type = Date.class),
            @ColumnResult(name = "family", type = String.class),
            @ColumnResult(name = "familyEventTypeId", type = Character.class)
        }
    )
)
public class FamilyEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "family_event_date")
    private Date familyEventDate;

    private String family;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "family_event_type_id")
    private FamilyEventType familyEventType;

    public String getFamily() {
        return family;
    }

    public Date getFamilyEventDate() {
        return familyEventDate;
    }

    public FamilyEventType getFamilyEventType() {
        return familyEventType;
    }

    public Long getId() {
        return id;
    }
}
