package com.example.churchbillboard2.models;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;



    public void setFamily(String family) {
        this.family = family;
    }

    public void setFamilyEventDate(Long familyEventDate) {
        this.familyEventDate = familyEventDate;
    }

    public void setFamilyEventTypeId(String familyEventTypeId) {
        this.familyEventTypeId = familyEventTypeId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFamily() {
        return family;
    }

    public Long getFamilyEventDate() {
        return familyEventDate;
    }

    public String getFamilyEventTypeId() {
        return familyEventTypeId;
    }

    public Long getId() {
        return id;
    }

}
