package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.example.churchbillboard2.models.FamilyEvent;
import com.example.churchbillboard2.models.FamilyEventDTO;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query("SELECT NEW com.example.churchbillboard2.models.FamilyEventDTO(f.id, f.familyEventDate, f.family, f.familyEventType.id) FROM FamilyEvent f WHERE f.familyEventDate BETWEEN ?1 AND ?2")
    ArrayList<FamilyEventDTO> getFamilyEventsBetween(String startDate, String endDate);

    // ArrayList<FamilyEvent> getFamilyEventsBetween(String startDate, String
    // endDate);
}
