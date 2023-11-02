package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query("SELECT * FROM family_events WHERE family_event_date BETWEEN ?1 AND ?2")
    ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String endDate);
}
