package com.medibook.entities;

import jakarta.persistence.*;

@Entity
@Table(name ="image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path; // url que devuelve Cloudinary

    public Image() {
    }

    public Image(Long id, String path) {
        this.id = id;
        this.path = path;
    }

    public Image(String path, Typeroom typeroom) {
        this.path = path;
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
}
