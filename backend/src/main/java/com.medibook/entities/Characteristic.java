package com.medibook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "characteristic")
public class Characteristic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String urlicon;

    @ManyToMany(mappedBy = "characteristics")
    @JsonIgnore
    private Set<Room> rooms;

    public Characteristic() {
    }

    public Characteristic(Long id, String name, String urlicon, Set<Room> rooms) {
        this.id = id;
        this.name = name;
        this.urlicon = urlicon;
        this.rooms = rooms;
    }

    public Characteristic(String name, String urlicon, Set<Room> rooms) {
        this.name = name;
        this.urlicon = urlicon;
        this.rooms = rooms;
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

    public String getUrlicon() {
        return urlicon;
    }

    public void setUrlicon(String urlicon) {
        this.urlicon = urlicon;
    }

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }
}