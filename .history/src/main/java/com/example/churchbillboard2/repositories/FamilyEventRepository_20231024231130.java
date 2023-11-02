package com.example.churchbillboard2.repositories;

import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.churchbillboard2.models.FamilyEvent;

public interface FamilyEventRepository extends JpaRepository<FamilyEvent, Long> {

    @Query("SELECT fe, fe.familyEventType.Id FROM FamilyEvent fe WHERE fe.familyEventDate = :date")
    ArrayList<FamilyEvent> findByFamilyEventDateWithEventType(@Param("date") Date familyEventDate);
}
