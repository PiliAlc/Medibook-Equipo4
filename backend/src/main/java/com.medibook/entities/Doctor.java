package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String tuition;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Booking> bookings;

    @ManyToOne
    @JoinColumn(name = "specialty_id", nullable = false) // Con que columna en la bdd se va a relacionar.
    private Specialty specialty;

    public Doctor() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Doctor(String name, String lastname, String tuition, Set<Booking> bookings, Specialty specialty) {
        this.name = name;
        this.lastname = lastname;
        this.tuition = tuition;
        this.bookings = bookings;
        this.specialty = specialty;
    }

    public Doctor(Long id, String name, String lastname, String tuition, Set<Booking> bookings, Specialty specialty) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.tuition = tuition;
        this.bookings = bookings;
        this.specialty = specialty;
    }
}
