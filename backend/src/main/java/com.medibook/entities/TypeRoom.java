package com.medibook.entities;


import jakarta.persistence.*;




@Entity
@Table(name="typeRooms")
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long type_id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "rooms_id",nullable = false)
    private Room room;

    public TypeRoom() {
    }

    public TypeRoom(String name, Room room) {
        this.name = name;
        this.room = room;
    }

    public TypeRoom(Long type_id, String name, Room room) {
        this.type_id = type_id;
        this.name = name;
        this.room = room;
    }

    public Long getType_id() {
        return type_id;
    }

    public void setType_id(Long type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}



