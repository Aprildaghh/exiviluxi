package com.aprildaghh.exiviluxi.Model.Crm;

import java.sql.Date;

public class CrmPresentation {

    private Date date;
    private String password;
    private String videoUrl;
    private String backgroundColor;
    private String backgroundUrl;

    public CrmPresentation() {
    }

    public CrmPresentation(Date date, String password, String videoUrl, String backgroundColor, String backgroundUrl) {
        this.date = date;
        this.password = password;
        this.videoUrl = videoUrl;
        this.backgroundColor = backgroundColor;
        this.backgroundUrl = backgroundUrl;
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
