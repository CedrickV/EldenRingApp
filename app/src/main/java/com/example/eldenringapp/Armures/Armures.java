package com.example.eldenringapp.Armures;

import java.io.Serializable;

public class Armures implements Serializable {
    private String name;
    private String description;
    private String armuresUrl;

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

    public String getArmuresUrl() {
        return armuresUrl;
    }

    public void setArmuresUrl(String armuresUrl) {
        this.armuresUrl = armuresUrl;
    }
}
