package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="doctors")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long doctors_id;
    private String name;
    private String lastname;
    private String tuition;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "doctor")
    @JsonIgnore
    private Set<Specialty> specialties;


    public Doctor() {
    }

    public Doctor(String name, String lastname, String tuition, Set<Booking> bookings, Set<Specialty> specialties) {
        this.name = name;
        this.lastname = lastname;
        this.tuition = tuition;
        this.bookings = bookings;
        this.specialties = specialties;
    }

    public Doctor(Long doctors_id, String name, String lastname, String tuition, Set<Booking> bookings, Set<Specialty> specialties) {
        this.doctors_id = doctors_id;
        this.name = name;
        this.lastname = lastname;
        this.tuition = tuition;
        this.bookings = bookings;
        this.specialties = specialties;
    }

    public Long getDoctors_id() {
        return doctors_id;
    }

    public void setDoctors_id(Long doctors_id) {
        this.doctors_id = doctors_id;
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

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
