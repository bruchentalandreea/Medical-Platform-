package com.example.springdemo.DTO;


import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private Set<String> roles;
    private String address;
    private String email;
    private String gender;
    private String name;
    private Timestamp birthDate;

    public UserDTO(Integer id, String username, String password, Set<String> roles, String address, String email, String gender, String name, Timestamp birthDate) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.address = address;
        this.email = email;
        this.gender = gender;
        this.name = name;
        this.birthDate = birthDate;
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

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Timestamp birthDate) {
        this.birthDate = birthDate;
    }
}
