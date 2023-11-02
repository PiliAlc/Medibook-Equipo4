package com.medibook.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="shift")
public class Shift {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shift;
    private String shift_range;

    /* @OneToMany(mappedBy = "shift")
    @JsonIgnore
    private Set<Booking> bookings;
    */

    public Shift() {
    }

    public Shift(String shift, String shift_range) {
        this.shift = shift;
        this.shift_range = shift_range;
    }

    public Shift(Long id, String shift, String shift_range) {
        this.id = id;
        this.shift = shift;
        this.shift_range = shift_range;
    }

    public Long getShifts_id() {
        return id;
    }

    public void setShifts_id(Long id) {
        this.id = id;
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

}





