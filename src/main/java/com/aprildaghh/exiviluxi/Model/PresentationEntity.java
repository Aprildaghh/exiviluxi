package com.aprildaghh.exiviluxi.Model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name="presentation")
public class PresentationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="presentation_date")
    private Date date;

    @Column(name="password")
    private String password;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name="user_id")
    private UserEntity user;

    public PresentationEntity() {
    }

    public PresentationEntity(int id, Date date, String password, UserEntity user) {
        this.id = id;
        this.date = date;
        this.password = password;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
