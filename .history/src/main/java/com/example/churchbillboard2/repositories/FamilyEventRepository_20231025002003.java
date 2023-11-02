package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query("SELECT fe FROM FamilyEvent fe JOIN FETCH fe.familyEventType WHERE (fe.familyEventDate BETWEEN ?1 AND fe.familyEventDate <= ?2)")
    ArrayList<FamilyEvent> findBetweenDatesWithEventType(String startDate, String endDate);

}
