package com.example.springdemo.entities;

import com.example.springdemo.entities.enums.RoleType;
import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name="type")
    @Enumerated(EnumType.STRING)
    private RoleType role;

    public UserRole(RoleType role) {
        this.role = role;
    }

    public UserRole() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }


}