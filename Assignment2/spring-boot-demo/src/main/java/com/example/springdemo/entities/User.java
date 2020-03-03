package com.example.springdemo.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.sql.Timestamp;
import java.util.Objects;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)

public class User {
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

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
                )
    private Set<UserRole> roles = new HashSet<>();

    public User(){}

    public User(Integer id, String username, Set<String> roles, String email, String name, Timestamp birth_date, String gender, String address) {
    }

    public User(Integer id,String username, String password, String email, String name, Timestamp birthDate, String gender, String adress) {
        this.id=id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.name = name;
        this.birth_date = birth_date;
        this.gender = gender;
        this.address = address;
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


    public Set<UserRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<UserRole> roles) {
        this.roles = roles;
    }

    public void addRole(UserRole role){
        roles.add(role);
    }

    public void removeRole(UserRole role){
        roles.remove(role);

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getUsername().equals(user.getUsername()) &&
                getPassword().equals(user.getPassword()) &&
                Objects.equals(getEmail(), user.getEmail()) &&
                getName().equals(user.getName()) &&
                getBirth_date().equals(user.getBirth_date()) &&
                getGender() == user.getGender() &&
                Objects.equals(getAddress(), user.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUsername(), getPassword(), getEmail(), getName(), getBirth_date(), getGender(), getAddress());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", birthDate=" + birth_date +
                ", gender=" + gender +
                ", adress='" + address + '\'' +
                '}';
    }

}
