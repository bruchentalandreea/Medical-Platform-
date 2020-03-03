package com.example.springdemo.DTO;

import com.example.springdemo.entities.Patient;

import java.sql.Timestamp;
import java.util.List;

public class CreatePatientDTO {

    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String address;
    private String email;
    private Timestamp birthDate;
    private String medical_record;


    public static CreatePatientDTO  ofEntity(Patient patient) {
        CreatePatientDTO createPatientDTO = new CreatePatientDTO();
        createPatientDTO.setId(patient.getId());
        createPatientDTO.setName(patient.getUsername());
        createPatientDTO.setName(patient.getPassword());
        createPatientDTO.setName(patient.getName());
        createPatientDTO.setGender(patient.getGender());
        createPatientDTO.setAddress(patient.getAddress());
        createPatientDTO.setAddress(patient.getEmail());
        createPatientDTO.setBirthDate(patient.getBirth_date());
        createPatientDTO.setMedical_record(patient.getMedicalRecord());

        return createPatientDTO;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }

    public String getMedical_record() {
        return medical_record;
    }

    public void setMedical_record(String medical_record) {
        this.medical_record = medical_record;
    }
}
