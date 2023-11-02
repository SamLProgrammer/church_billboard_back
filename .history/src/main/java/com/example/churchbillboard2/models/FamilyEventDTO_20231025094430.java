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
                System.out.println(sourceField);
                System.out.println(sourceField.get(source));
                sourceField.setAccessible(true);
                field.set(this, sourceField.get(source));
            } catch (Exception e) {
                System.out.println("something wrong: " + e.getMessage());
            }
        }
    }

}
