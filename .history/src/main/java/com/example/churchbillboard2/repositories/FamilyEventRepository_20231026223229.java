package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.models.FamilyEventDTO2;

import jakarta.persistence.SqlResultSetMapping;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = 
        "SELECT f.id AS id, f.family_event_date AS familyEventDate, " + 
        "f.family AS family, f.family_event_type_id AS familyEventTypeId " +
        "FROM family_events f WHERE " +  
        "(f.family_event_date BETWEEN ?1 AND ?2)", 
        nativeQuery = true)
    @SqlResultSetMapping(name = "FamilyEventDTOMapping")
    ArrayList<FamilyEventDTO2> getFamilyEventsBetween(String startDate, String endDate);
}
