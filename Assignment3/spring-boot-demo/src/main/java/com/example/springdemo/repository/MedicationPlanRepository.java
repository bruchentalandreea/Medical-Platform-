package com.example.springdemo.repository;

import com.example.springdemo.entities.MedicationPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MedicationPlanRepository extends JpaRepository<MedicationPlan, Integer>, CrudRepository<MedicationPlan,Integer>
{

}
