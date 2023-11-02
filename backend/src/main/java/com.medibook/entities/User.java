package com.medibook.entities;

import jakarta.persistence.*;

@Entity
@Table(name="user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String username;
    private String password;

    /*@Enumerated(EnumType.STRING)
    private UserRol userRol;*/

    public User() {
    }

    public User(Long id, String name, String lastname, String username, String password) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //Parte configuración del security
    /*@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(UserRol.name());

        return Collections.singletonList(grantedAuthority);*/
}
