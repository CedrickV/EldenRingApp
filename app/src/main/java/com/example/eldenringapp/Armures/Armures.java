package com.example.eldenringapp.Armures;

import java.io.Serializable;

public class Armures implements Serializable {
    private String name;
    private String description;
    private String armuresUrl;
    private String weight;
    private String poise,robust,focus,vitality, immunity;

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public String getPoise() {
        return poise;
    }

    public void setPoise(String poise) {
        this.poise = poise;
    }

    public String getRobust() {
        return robust;
    }

    public void setRobust(String robust) {
        this.robust = robust;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getVitality() {
        return vitality;
    }

    public void setVitality(String vitality) {
        this.vitality = vitality;
    }

    public String getImmunity() {
        return immunity;
    }

    public void setImmunity(String immunity) {
        this.immunity = immunity;
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
