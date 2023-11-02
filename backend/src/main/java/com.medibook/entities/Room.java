package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Boolean favourite;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Booking> bookings;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Image> images;

    @ManyToOne
    @JoinColumn(name = "typeroom_id",nullable = false)
    private Typeroom typeroom;

    public Room() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Typeroom getTyperoom() {
        return typeroom;
    }

    public void setTyperoom(Typeroom typeroom) {
        this.typeroom = typeroom;
    }

    public Room(String name, String description, Boolean favourite, Set<Booking> bookings, Set<Image> images, Typeroom typeroom) {
        this.name = name;
        this.description = description;
        this.favourite = favourite;
        this.bookings = bookings;
        this.images = images;
        this.typeroom = typeroom;
    }

    public Room(Long id, String name, String description, Boolean favourite, Set<Booking> bookings, Set<Image> images, Typeroom typeroom) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.favourite = favourite;
        this.bookings = bookings;
        this.images = images;
        this.typeroom = typeroom;
    }
}
