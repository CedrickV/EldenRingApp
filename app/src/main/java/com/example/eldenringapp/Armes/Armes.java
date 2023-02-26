package com.example.eldenringapp.Armes;

import java.io.Serializable;

public class Armes implements Serializable {
    private String name;
    private String description;
    private String armeUrl;

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
