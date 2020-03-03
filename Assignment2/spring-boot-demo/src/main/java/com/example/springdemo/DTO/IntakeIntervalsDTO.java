package com.example.springdemo.DTO;

import java.io.Serializable;
import java.sql.Timestamp;

public class IntakeIntervalsDTO  {

    private Integer id;
    private MedicationDTO medication;
    private Timestamp startDate;
    private Timestamp endDate;
    private String takes;

    public IntakeIntervalsDTO(Integer id, MedicationDTO medication, Timestamp startDate, Timestamp endDate, String takes) {
        this.id = id;
        this.medication = medication;
        this.startDate = startDate;
        this.endDate = endDate;
        this.takes = takes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MedicationDTO getMedication() {
        return medication;
    }

    public void setMedication(MedicationDTO medication) {
        this.medication = medication;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public String getTakes() {
        return takes;
    }

    public void setTakes(String takes) {
        this.takes = takes;
    }
}
