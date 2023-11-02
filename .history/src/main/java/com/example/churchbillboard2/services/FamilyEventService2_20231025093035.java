package com.example.churchbillboard2.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.churchbillboard2.models.FamilyEventDTO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Service
public class FamilyEventService2 {

    @PersistenceContext
    private EntityManager entityManager;

    public List<FamilyEventDTO> getFamilyEventsBetween(String startDate, String endDate) {
        String sql = "SELECT f.id, f.family_event_date, f.family, f.family_event_type_id AS familyEventTypeId " +
                     "FROM family_events f " +
                     "WHERE (f.family_event_date BETWEEN ?1 AND ?2)";

        List<Object[]> results = entityManager.createNativeQuery(sql)
                .setParameter(1, startDate)
                .setParameter(2, endDate)
                .getResultList();

        List<FamilyEventDTO> familyEvents = new ArrayList<>();
        for (Object[] result : results) {
            familyEvents.add(new FamilyEventDTO(result));
        }

        return familyEvents;
    }
}
