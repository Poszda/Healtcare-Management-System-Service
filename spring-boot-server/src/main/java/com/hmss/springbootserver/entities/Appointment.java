package com.hmss.springbootserver.entities;

import jakarta.persistence.*;

import javax.print.Doc;

@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL) //think about cascade type //optiona=false?
    Diagnostic diagnostic;
    @ManyToOne(fetch = FetchType.LAZY) // by default EAGER
    @JoinColumn(name="patient_id")
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY) // by default EAGER
    @JoinColumn(name="doctor_id")
    private Doctor doctor;

    @OneToOne(fetch = FetchType.LAZY) // by default EAGER
    @JoinColumn(name = "procedure_id")
    private Procedure procedure;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Diagnostic getDiagnostic() {
        return diagnostic;
    }

    public void setDiagnostic(Diagnostic diagnostic) {
        this.diagnostic = diagnostic;
    }

    public Procedure getProcedure() {
        return procedure;
    }

    public void setProcedure(Procedure procedure) {
        this.procedure = procedure;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
