package com.example.sunning.restauranthygienechecker.Models;


import android.widget.ListView;

import java.util.List;

public class User {
    private double latitude;
    private double longitude;
    private List<Establishment> favorites;

    public User() {
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public List<Establishment> getFavorites() {
        return favorites;
    }

    public void setFavorites(List<Establishment> favorites) {
        this.favorites = favorites;
    }
}
