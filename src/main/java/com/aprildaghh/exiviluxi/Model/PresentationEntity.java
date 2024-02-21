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

    @Column(name="video_url")
    private String videoUrl;

    @Column(name="background_color")
    private String backgroundColor;

    @Column(name="background_url")
    private String backgroundUrl;

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

    public PresentationEntity(int id, Date date, String password, String videoUrl, String backgroundColor, String backgroundUrl, UserEntity user) {
        this.id = id;
        this.date = date;
        this.password = password;
        this.videoUrl = videoUrl;
        this.backgroundColor = backgroundColor;
        this.backgroundUrl = backgroundUrl;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public String getBackgroundUrl() {
        return backgroundUrl;
    }

    public void setBackgroundUrl(String backgroundUrl) {
        this.backgroundUrl = backgroundUrl;
    }
}
