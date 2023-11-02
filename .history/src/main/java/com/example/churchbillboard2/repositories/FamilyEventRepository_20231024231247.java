package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query("SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE fe.familyEventDate >= :startDate AND fe.familyEventDate <= :endDate")
    ArrayList<FamilyEvent> findBetweenDatesWithEventType(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

}
