package com.example.churchbillboard2.models;

import java.lang.reflect.Field;

public class FamilyEventDTO {
    private Long id;
    private Long familyEventDate;
    private String family;
    private String familyEventTypeId;

    public FamilyEventDTO(Object source) {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            try {
                Field sourceField = source.getClass().getDeclaredField(field.getName());
                sourceField.setAccessible(true);
                field.set(this, sourceField.get(source));
            } catch (Exception e) {
                // Handle exceptions or logging here
            }
        }
    }
    
}
