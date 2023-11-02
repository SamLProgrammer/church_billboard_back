package com.example.churchbillboard2.models;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(ResultSet resultSet) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);  // Make the field accessible for setting its value

            try {
                String fieldName = field.getName();
                Object value = resultSet.getObject(fieldName);

                System.out.println("Field Name: " + fieldName);
                System.out.println("Field Value: " + value);

                if (value != null) {
                    field.set(this, value);
                }
            } catch (SQLException e) {
                // Handle SQL-related exceptions
                Logger.getLogger(FamilyEventDTO.class.getName()).log(Level.SEVERE, "SQL Error accessing field: " + field.getName(), e);
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
