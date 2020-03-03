package com.example.springdemo.repositories;

import com.example.springdemo.entities.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MedicationRepository extends JpaRepository<Medication, Integer>, CrudRepository<Medication,Integer> {
}
