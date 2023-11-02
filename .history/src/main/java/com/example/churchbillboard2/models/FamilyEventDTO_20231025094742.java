package com.example.churchbillboard2.models;

import java.lang.reflect.Field;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;

    // public FamilyEventDTO(Object source) {
    //     Field[] fields = this.getClass().getDeclaredFields();
    //     for (Field field : fields) {
    //         try {
    //             Field sourceField = source.getClass().getDeclaredField(field.getName());
    //             System.out.println(sourceField);
    //             System.out.println(sourceField.get(source));
    //             sourceField.setAccessible(true);
    //             field.set(this, sourceField.get(source));
    //         } catch (Exception e) {
    //             System.out.println("something wrong: " + e.getMessage());
    //         }
    //     }
    // }

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
