package com.medibook.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    @ManyToOne
    @JoinColumn(name = "shift_id")
    private Shift shift;

    public Booking() {
    }

    public Booking(LocalDate date, Shift shift, Doctor doctor, Room room) {
        this.date = date;
        this.shift = shift;
        this.doctor = doctor;
        this.room = room;
    }

    public Booking(Long id, LocalDate date, Doctor doctor, Room room, Shift shift) {
        this.id = id;
        this.date = date;
        this.doctor = doctor;
        this.room = room;
        this.shift = shift;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
