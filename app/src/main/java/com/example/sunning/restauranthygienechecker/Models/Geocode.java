package com.example.sunning.restauranthygienechecker.Models;


import com.fasterxml.jackson.annotation.JsonProperty;

public class Geocode {
    @JsonProperty("latitude")
    private String latitude;
    @JsonProperty("longitude")
    private String longitude;

    public Geocode() {
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
