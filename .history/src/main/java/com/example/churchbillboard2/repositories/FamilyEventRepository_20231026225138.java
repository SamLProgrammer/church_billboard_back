package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = 
    "SELECT f.id, f.family_event_date, f.family, f.family_event_type_id AS familyEventTypeId " +
    "FROM family_events f WHERE " +  
    "(f.family_event_date BETWEEN ?1 AND ?2) " + 
    "ORDER BY familyEventTypeId DESC", 
    nativeQuery = true)
    ArrayList<Object> getFamilyEventsBetween(String startDate, String endDate);
}
