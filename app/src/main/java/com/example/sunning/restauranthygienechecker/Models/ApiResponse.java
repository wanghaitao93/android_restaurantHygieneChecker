package com.example.sunning.restauranthygienechecker.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


public class ApiResponse {
    List<Establishment> establishments;
    @JsonIgnore
    List<String> meta;
    @JsonIgnore
    List<String> links;

    public ApiResponse() {
    }

    public List<Establishment> getEstablishments() {
        return establishments;
    }

    public void setEstablishments(List<Establishment> establishments) {
        this.establishments = establishments;
    }

}
