package com.example.eldenringapp.Classe;

import java.io.Serializable;

public class Classe implements Serializable {

    private String name;
    private String imageURL;
    private String description;

    private String intelligence, dex, vigor, mind, end, level, faith, arc, str;

    public void setStats(String lvl, String vig, String md, String end, String str, String dex, String it, String ft, String arc){
        this.level = "LEVEL : " +lvl;
        this.dex = "DEXTERITY : " + dex;
        this.vigor = "VIGOR : " + vig;
        this.mind = "MIND : " +md;
        this.end = "ENDURANCE : " +end;
        this.str = "STRENGTH : " + str;
        this.intelligence = "INTELLIGENCE : " + it;
        this.faith = "FAITH : " +ft;
        this.arc = "ARCANE : " +arc;
    }


    public Classe(String name, String imageURL, String description) {
        this.name = name;
        this.imageURL = imageURL;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(String intelligence) {
        this.intelligence = intelligence;
    }

    public String getDex() {
        return dex;
    }

    public void setDex(String dex) {
        this.dex = dex;
    }

    public String getVigor() {
        return vigor;
    }

    public void setVigor(String vigor) {
        this.vigor = vigor;
    }

    public String getMind() {
        return mind;
    }

    public void setMind(String mind) {
        this.mind = mind;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getFaith() {
        return faith;
    }

    public void setFaith(String faith) {
        this.faith = faith;
    }

    public String getArc() {
        return arc;
    }

    public void setArc(String arc) {
        this.arc = arc;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


}
