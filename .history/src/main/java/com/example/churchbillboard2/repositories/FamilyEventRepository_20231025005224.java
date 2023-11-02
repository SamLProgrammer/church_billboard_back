package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = "SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE (fe.familyEventDate BETWEEN ?1 AND '2023-10-01')", 
    nativeQuery = true)
    ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate);
    // @Query(value = "SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE (fe.familyEventDate BETWEEN ?1 AND ?2)", 
    // nativeQuery = true)
    // ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);

}
