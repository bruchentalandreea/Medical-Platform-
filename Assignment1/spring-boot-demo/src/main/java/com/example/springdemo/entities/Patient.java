package com.example.springdemo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name="patient")
public class Patient extends User{


    @Column(name="medical_record")
    private String medicalRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id")
    private User doctor;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name="caregiver_id")
    private User caregiver;


    public Patient(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public Patient(Integer id,String username, String password, String email, String name, Timestamp birthDate, String gender, String adress, String medicalRecord) {
        super(id, username, password, email, name, birthDate, gender, adress);
        this.medicalRecord = medicalRecord;
    }



    public String getMedicalRecord() {
        return medicalRecord;
    }

    public void setMedicalRecord(String medicalRecord) {
        this.medicalRecord = medicalRecord;
    }

    public User getDoctor() {
        return doctor;
    }

    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }

    public User getCaregiver() {
        return caregiver;
    }

    public void setCaregiver(User caregiver) {
        this.caregiver = caregiver;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Patient)) return false;
        if (!super.equals(o)) return false;
        Patient patient = (Patient) o;
        return Objects.equals(getMedicalRecord(), patient.getMedicalRecord()) &&
                Objects.equals(getDoctor(), patient.getDoctor()) &&
                Objects.equals(getCaregiver(), patient.getCaregiver());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getMedicalRecord(), getDoctor(), getCaregiver());
    }
}
