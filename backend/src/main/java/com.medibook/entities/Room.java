package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import com.medibook.entities.TypeRoom;

import java.util.Set;

@Entity
@Table(name="rooms")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rooms_id;

    private String name;
    private String description;
    private Boolean favourite;

    private String url1;
    private String url2;
    private String url3;
    private String url4;
    private String url5;

    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<Booking> bookings;


    @OneToMany(mappedBy = "room")
    @JsonIgnore
    private Set<TypeRoom> typeRooms;

    public Room() {
    }

    public Room(String name, String description, Boolean favourite, String url1, String url2, String url3, String url4, String url5, Set<Booking> bookings, Set<TypeRoom> typeRooms) {
        this.name = name;
        this.description = description;
        this.favourite = favourite;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.bookings = bookings;
        this.typeRooms = typeRooms;
    }

    public Room(Long rooms_id, String name, String description, Boolean favourite, String url1, String url2, String url3, String url4, String url5, Set<Booking> bookings, Set<TypeRoom> typeRooms) {
        this.rooms_id = rooms_id;
        this.name = name;
        this.description = description;
        this.favourite = favourite;
        this.url1 = url1;
        this.url2 = url2;
        this.url3 = url3;
        this.url4 = url4;
        this.url5 = url5;
        this.bookings = bookings;
        this.typeRooms = typeRooms;
    }

    public Long getRooms_id() {
        return rooms_id;
    }

    public void setRooms_id(Long rooms_id) {
        this.rooms_id = rooms_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TypeRoom> getTypeRooms() {
        return typeRooms;
    }

    public void setTypeRooms(Set<TypeRoom> typeRooms) {
        this.typeRooms = typeRooms;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl1() {
        return url1;
    }

    public void setUrl1(String url1) {
        this.url1 = url1;
    }

    public String getUrl2() {
        return url2;
    }

    public void setUrl2(String url2) {
        this.url2 = url2;
    }

    public String getUrl3() {
        return url3;
    }

    public void setUrl3(String url3) {
        this.url3 = url3;
    }

    public String getUrl4() {
        return url4;
    }

    public void setUrl4(String url4) {
        this.url4 = url4;
    }

    public String getUrl5() {
        return url5;
    }

    public void setUrl5(String url5) {
        this.url5 = url5;
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }
    public Boolean getFavourite() {
        return favourite;
    }

    public void setFavourite(Boolean favourite) {
        this.favourite = favourite;
    }
}
