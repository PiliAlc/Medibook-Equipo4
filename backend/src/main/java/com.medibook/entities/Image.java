package com.medibook.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path; // Almacena la url a la S3
    @ManyToOne
    @JoinColumn(name = "room_id", nullable = true)
    private Room room;
    @OneToOne
    @JoinColumn(name = "typeroom_id", nullable = false)
    private Typeroom typeroom;

    public Image() {
    }

    public Image(String path, Room room, Typeroom typeroom) {
        this.path = path;
        this.room = room;
        this.typeroom = typeroom;
    }

    public Image(Long id, String path, Room room, Typeroom typeroom) {
        this.id = id;
        this.path = path;
        this.room = room;
        this.typeroom = typeroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Typeroom getTyperoom() {
        return typeroom;
    }

    public void setTyperoom(Typeroom typeroom) {
        this.typeroom = typeroom;
    }
}
