package com.example.springdemo.entities;


import com.example.springdemo.entities.enums.IntakeMoments;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="intake_interval")
public class IntakeIntervals {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medication_plan_id")
    private MedicationPlan medicationPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="medication_id")
    private Medication medication;

    @Column(name="take_moments")
    private String takes;

    @Column(name="start_date")
    private Timestamp start_date;

    @Column(name="end_date")
    private Timestamp end_date;

    public IntakeIntervals() {
    }

    public IntakeIntervals(MedicationPlan medicationPlan, Medication medication, String takes, Timestamp start_date, Timestamp end_date) {
        this.medicationPlan = medicationPlan;
        this.medication = medication;
        this.takes = takes;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public MedicationPlan getMedicationPlan() {
        return medicationPlan;
    }

    public void setMedicationPlan(MedicationPlan medicationPlan) {
        this.medicationPlan = medicationPlan;
    }

    public Medication getMedication() {
        return medication;
    }

    public void setMedication(Medication medication) {
        this.medication = medication;
    }

    public String getTakes() {
        return takes;
    }

    public void setTakes(String takes) {
        this.takes = takes;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof IntakeIntervals)) return false;
        IntakeIntervals that = (IntakeIntervals) o;
        return getId().equals(that.getId()) &&
                Objects.equals(getMedicationPlan(), that.getMedicationPlan()) &&
                Objects.equals(getMedication(), that.getMedication()) &&
                Objects.equals(getTakes(), that.getTakes()) &&
                Objects.equals(getStart_date(), that.getStart_date()) &&
                Objects.equals(getEnd_date(), that.getEnd_date());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMedicationPlan(), getMedication(), getTakes(), getStart_date(), getEnd_date());
    }

    @Override
    public String toString() {
        return "IntakeInterval{" +
                "id=" + id +
                ", medicationPlan=" + medicationPlan +
                ", medication=" + medication +
                ", takes='" + takes + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                '}';
    }
}
