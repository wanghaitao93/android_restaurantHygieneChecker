package com.example.sunning.restauranthygienechecker.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Score {
    @JsonProperty("Hygiene")
    private int hygiene;
    @JsonProperty("Structural")
    private int structural;
    @JsonProperty("ConfidenceInManagement")
    private int confidenceInManagement;

    public Score() {
    }

    public int getHygiene() {
        return hygiene;
    }

    public void setHygiene(int hygiene) {
        this.hygiene = hygiene;
    }

    public int getStructural() {
        return structural;
    }

    public void setStructural(int structural) {
        this.structural = structural;
    }

    public int getConfidenceInManagement() {
        return confidenceInManagement;
    }

    public void setConfidenceInManagement(int confidenceInManagement) {
        this.confidenceInManagement = confidenceInManagement;
    }
}
