package com.example.springdemo.entities;


public class MedicationPlan implements java.io.Serializable{

    private Integer id;
    private String name;
    private String start_date;
    private String end_date;
    private int taken;


    public MedicationPlan(Integer id ,String start_date, String end_date)
    {
        this.id=id;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    public MedicationPlan() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getStartDate() {
        return start_date;
    }

    public void setStartDate(String start_date) {
        this.start_date = start_date;
    }

    public String getEndDate() {
        return end_date;
    }

    public void setEndDate(String end_date) {
        this.end_date = end_date;
    }


    public int getTaken() {
        return taken;
    }

    public void setTaken(int taken) {
        this.taken = taken;
    }
}
