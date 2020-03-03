package com.example.springdemo.entities;


import javax.persistence.*;
import java.security.Timestamp;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="medication_plan")
public class MedicationPlan {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name="start_date")
    private Timestamp start_date;

    @Column(name="end_date")
    private Timestamp end_date;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="doctor_id")
    private User doctor;

    public MedicationPlan(Timestamp start_date, Timestamp end_date, Patient patient, User doctor)
    {
        this.start_date = start_date;
        this.end_date = end_date;
        this.patient = patient;
        this.doctor=doctor;
    }

    public MedicationPlan() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Timestamp getStartDate() {
        return start_date;
    }

    public void setStartDate(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEndDate() {
        return end_date;
    }

    public void setEndDate(Timestamp end_date) {
        this.end_date = end_date;
    }

    public User getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
}
