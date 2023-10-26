package com.medibook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="specialties")
public class Specialty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long specialties_id;
    private String name;
    private String descpription;

    @ManyToOne
    @JoinColumn(name = "doctors_id",nullable = false)
    private Doctor doctor;


    public Specialty() {
    }

    public Specialty(String name, String descpription, Doctor doctor) {
        this.name = name;
        this.descpription = descpription;
        this.doctor = doctor;
    }

    public Specialty(Long specialties_id, String name, String descpription, Doctor doctor) {
        this.specialties_id = specialties_id;
        this.name = name;
        this.descpription = descpription;
        this.doctor = doctor;
    }

    public Long getId() {
        return specialties_id;
    }

    public void setId(Long id) {
        this.specialties_id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescpription() {
        return descpription;
    }

    public void setDescpription(String descpription) {
        this.descpription = descpription;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
}
