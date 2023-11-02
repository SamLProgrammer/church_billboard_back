package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = "SELECT fe.*, fet.id AS family_event_type_id " +
       "FROM family_events fe " +
       "JOIN family_event_types fet ON fe.family_event_type_id = fet.id " +
       "WHERE (fe.family_event_date BETWEEN ?1 AND ?2)", nativeQuery = true)
    ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);

}
