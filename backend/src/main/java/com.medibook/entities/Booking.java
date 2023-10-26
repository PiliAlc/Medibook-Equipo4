package com.medibook.entities;


import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookings_id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "doctors_id",nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "rooms_id",nullable = false)
    private Room room;

    @ManyToOne
    @JoinColumn(name = "shifts_id",nullable = false)
    private Shift shift;

    public Booking() {
    }

    public Booking(LocalDate date, Shift shift, Doctor doctor, Room room) {
        this.date = date;
        this.shift = shift;
        this.doctor = doctor;
        this.room = room;
    }

    public Booking(Long bookings_id, LocalDate date, Doctor doctor, Room room, Shift shift) {
        this.bookings_id = bookings_id;
        this.date = date;
        this.doctor = doctor;
        this.room = room;
        this.shift = shift;
    }

    public Long getId() {
        return bookings_id;
    }

    public void setId(Long id) {
        this.bookings_id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
