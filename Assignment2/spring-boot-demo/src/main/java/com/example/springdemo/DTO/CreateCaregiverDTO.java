package com.example.springdemo.DTO;

import com.example.springdemo.entities.Caregiver;
import com.example.springdemo.entities.Patient;
import org.springframework.util.CollectionUtils;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;


public class CreateCaregiverDTO {
    private Integer id;
    private String username;
    private String password;
    private String name;
    private String gender;
    private String address;
    private String email;
    private Timestamp birthDate;
    private List<Integer> patients;


    public static CreateCaregiverDTO ofEntity(Caregiver caregiver) {
        CreateCaregiverDTO createCaregiverDTO = new CreateCaregiverDTO();
        createCaregiverDTO.setId(caregiver.getId());
        createCaregiverDTO.setName(caregiver.getUsername());
        createCaregiverDTO.setName(caregiver.getPassword());
        createCaregiverDTO.setName(caregiver.getName());
        createCaregiverDTO.setGender(caregiver.getGender());
        createCaregiverDTO.setAddress(caregiver.getAddress());
        createCaregiverDTO.setAddress(caregiver.getEmail());
        createCaregiverDTO.setBirthDate(caregiver.getBirth_date());
        if (!CollectionUtils.isEmpty(caregiver.getPatients())) {
            createCaregiverDTO.setPatients(caregiver.getPatients().stream()
                    .map(Patient::getId)
                    .collect(Collectors.toList()));
        }
        return createCaregiverDTO;
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

    public List<Integer> getPatients() {
        return patients;
    }

    public void setPatients(List<Integer> patients) {
        this.patients = patients;
    }
}
