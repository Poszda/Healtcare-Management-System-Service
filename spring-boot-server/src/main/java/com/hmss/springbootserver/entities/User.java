package com.hmss.springbootserver.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User { //parent
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String lastName;
    private String firstName;
    private String username;
    private String email;
    private String password;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY) //nu merge cu orphanRemoval // nu se aplica la baza de date ce cretin
    private Doctor doctor;

    @OneToOne(mappedBy = "user", cascade = CascadeType.REMOVE,fetch = FetchType.LAZY) //nu merge cu orphanRemoval // nu se aplica la baza de date ce cretin
    private Patient patient;

    public User(Long id, String lastName, String firstName, String username, String email, String password, Patient patient, Doctor doctor) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.username = username;
        this.email = email;
        this.password = password;
        this.doctor = doctor;
        this.patient = patient;
    }

    public User() {

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
