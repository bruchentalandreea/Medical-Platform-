package com.example.springdemo.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

import static javax.persistence.GenerationType.IDENTITY;


@Entity
@Table(name = "caregiver")
public class Caregiver {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "username", length = 20)
    private String username;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "name")
    private String name;

    @Column(name = "birth_date")
    private Timestamp birth_date;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "caregiver", cascade = CascadeType.ALL)
    private List<Patient> patients;

    public Caregiver(String username, String password, String email, String name, Timestamp birth_date, String gender, String address, List<Patient> patients) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
        this.patients = patients;
    }

    public Caregiver(){}

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Timestamp birth_date) {
        this.birth_date = birth_date;
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

    public List<Patient> getPatients() {
        return patients;
    }

    public void setPatients(List<Patient> patients) {
        this.patients = patients;
    }
}
