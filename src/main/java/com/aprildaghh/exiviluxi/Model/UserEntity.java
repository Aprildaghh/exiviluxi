package com.aprildaghh.exiviluxi.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @OneToMany(mappedBy = "user", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    List<PresentationEntity> presentations;

    public UserEntity() {
        presentations = new ArrayList<>();
    }

    public UserEntity(int id, String username, String password, List<PresentationEntity> presentations) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.presentations = presentations;
    }

    public void addPresentation(PresentationEntity presentationEntity)
    {
        presentations.add(presentationEntity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public List<PresentationEntity> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<PresentationEntity> presentations) {
        this.presentations = presentations;
    }
}
