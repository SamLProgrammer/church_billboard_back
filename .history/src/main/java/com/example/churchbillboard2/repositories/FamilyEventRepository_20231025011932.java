package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = "SELECT f.id AS family_event_id, f.family_event_date, f.family, f.family_event_type_id, t.id AS family_event_type_id " +
       "FROM family_events f " +
       "INNER JOIN family_event_types t ON f.family_event_type_id = t.id " +
       "WHERE (f.family_event_date BETWEEN ?1 AND ?2)", nativeQuery = true)
    ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);
    // @Query(value = "SELECT * FROM family_events WHERE (family_event_date BETWEEN ?1 AND ?2)", nativeQuery = true)
    // ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);

    // SELECT fe.family_event_type_id
    // FROM family_events fe
    // WHERE fe.family_event_date BETWEEN '2023-10-01' AND '2023-10-31'

}
