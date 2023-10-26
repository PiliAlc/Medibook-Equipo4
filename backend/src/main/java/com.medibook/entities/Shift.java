package com.medibook.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="shifts")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shifts_id;
    private String shift;
    private String shift_range;

    @OneToMany(mappedBy = "shift")
    @JsonIgnore
    private Set<Booking> bookings;


    public Shift() {
    }

    public Shift(String shift, String shift_range, Set<Booking> bookings) {
        this.shift = shift;
        this.shift_range = shift_range;
        this.bookings = bookings;
    }

    public Shift(Long shifts_id, String shift, String shift_range, Set<Booking> bookings) {
        this.shifts_id = shifts_id;
        this.shift = shift;
        this.shift_range = shift_range;
        this.bookings = bookings;
    }

    public Long getShifts_id() {
        return shifts_id;
    }

    public void setShifts_id(Long shifts_id) {
        this.shifts_id = shifts_id;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getShift_range() {
        return shift_range;
    }

    public void setShift_range(String shift_range) {
        this.shift_range = shift_range;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
}





