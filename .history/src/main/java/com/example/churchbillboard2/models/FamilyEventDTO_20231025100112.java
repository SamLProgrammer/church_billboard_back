package com.example.churchbillboard2.models;

import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(Object source) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);  // Make the field accessible for setting its value

            try {
                Field sourceField = source.getClass().getDeclaredField(field.getName());
                sourceField.setAccessible(true);
                Object value = sourceField.get(source);

                System.out.println("Field Name: " + field.getName());
                System.out.println("Field Value: " + value);

                if (value != null) {
                    field.set(this, value);
                }
            } catch (NoSuchFieldException e) {
                // Handle the case where the field doesn't exist in the source object
                Logger.getLogger(FamilyEventDTO.class.getName()).log(Level.WARNING, "Field not found: " + field.getName(), e);
            } catch (IllegalAccessException e) {
                // Handle issues with field accessibility
                Logger.getLogger(FamilyEventDTO.class.getName()).log(Level.SEVERE, "Error accessing field: " + field.getName(), e);
            } catch (Exception e) {
                // Handle other exceptions
                Logger.getLogger(FamilyEventDTO.class.getName()).log(Level.SEVERE, "An error occurred while setting field: " + field.getName(), e);
            }
        }
    }

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
