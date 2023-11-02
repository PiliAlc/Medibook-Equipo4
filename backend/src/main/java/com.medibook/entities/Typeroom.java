package com.medibook.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table(name="typeroom")
public class Typeroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "typeroom") // Como se llama la propiedad en la clase con la que me estoy relacionando.
    @JsonIgnore // Cuando alguien mapee con un dto, que no llame a la propiedad turnos, porque entra en loop infinito.
    private Set<Room> rooms;

    @OneToMany(mappedBy = "typeroom") // Como se llama la propiedad en la clase con la que me estoy relacionando.
    @JsonIgnore // Cuando alguien mapee con un dto, que no llame a la propiedad turnos, porque entra en loop infinito.
    private Set<Image> images;

    public Typeroom() {
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

    public Set<Room> getRooms() {
        return rooms;
    }

    public void setRooms(Set<Room> rooms) {
        this.rooms = rooms;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Typeroom(String name, String description, Set<Room> rooms, Set<Image> images) {
        this.name = name;
        this.description = description;
        this.rooms = rooms;
        this.images = images;
    }

    public Typeroom(Long id, String name, String description, Set<Room> rooms, Set<Image> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rooms = rooms;
        this.images = images;
    }
}





