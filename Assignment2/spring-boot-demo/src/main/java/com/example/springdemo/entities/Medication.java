package com.example.springdemo.entities;

import javax.persistence.*;

import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="medication")
public class Medication {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="side_effects")
    private String side_effects;

    public Medication() {
    }

    public Medication(String name, String side_effects) {
        this.name = name;
        this.side_effects = side_effects;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSideEffects() {
        return side_effects;
    }

    public void setSideEffects(String side_effects) {
        this.side_effects = side_effects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medication that = (Medication) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(side_effects, that.side_effects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, side_effects);
    }

    @Override
    public String toString() {
        return "Medication{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", side_effects='" + side_effects + '\'' +
                '}';
    }
}
