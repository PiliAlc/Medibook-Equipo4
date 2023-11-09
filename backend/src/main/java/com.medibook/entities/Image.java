package com.medibook.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path; // url que devuelve Cloudinary

    @OneToOne(mappedBy = "image")
    private Typeroom typeroom;

    public Image() {
    }

    public Image(Long id, String path, Typeroom typeroom) {
        this.id = id;
        this.path = path;
        this.typeroom = typeroom;
    }

    public Image(String path, Typeroom typeroom) {
        this.path = path;
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

    public Typeroom getTyperoom() {
        return typeroom;
    }

    public void setTyperoom(Typeroom typeroom) {
        this.typeroom = typeroom;
    }
}
