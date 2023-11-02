package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query(value = "SELECT * FROM family_events", 
    nativeQuery = true)
    ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);

}
