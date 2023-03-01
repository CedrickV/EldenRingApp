package com.example.eldenringapp.Armes;

import java.io.Serializable;

public class Armes implements Serializable {
    private String name;
    private String description;
    private String armeUrl;

    private String phy;
    private String mag;
    private String fire;
    private String ligt;
    private String holy;

    public String getPhy() {
        return phy;
    }

    public void setPhy(String phy) {
        this.phy = phy;
    }

    public String getMag() {
        return mag;
    }

    public void setMag(String mag) {
        this.mag = mag;
    }

    public String getFire() {
        return fire;
    }

    public void setFire(String fire) {
        this.fire = fire;
    }

    public String getLigt() {
        return ligt;
    }

    public void setLigt(String ligt) {
        this.ligt = ligt;
    }

    public String getHoly() {
        return holy;
    }

    public void setHoly(String holy) {
        this.holy = holy;
    }

    public String getCrit() {
        return crit;
    }

    public void setCrit(String crit) {
        this.crit = crit;
    }

    private String crit;

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

    public String getArmeUrl() {
        return armeUrl;
    }

    public void setArmeUrl(String armeUrl) {
        this.armeUrl = armeUrl;
    }
}
