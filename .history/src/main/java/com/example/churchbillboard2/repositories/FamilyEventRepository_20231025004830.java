package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = "SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE (fe.familyEventDate BETWEEN :startDate AND :endDate)", 
    nativeQuery = true)
    ArrayList<FamilyEvent> getFamilyEventsBetween(@Param("startDate") String startDate, @Param("endDate") String endDate);
    // @Query(value = "SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE (fe.familyEventDate BETWEEN ?1 AND ?2)", 
    // nativeQuery = true)
    // ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);

}
