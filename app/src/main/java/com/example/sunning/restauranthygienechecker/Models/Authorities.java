package com.example.sunning.restauranthygienechecker.Models;

/**
 * Created by eric on 06/03/2018.
 */

public class Authorities {

    private String Name;
    private String LocalAuthorityId;
    private String RegionName;

    public String getAuthoritiesName() {
         return  Name;
    }
    public void setAuthoritiesName(String Name) {
        this.Name = Name;
    }

    public String getLocalAuthorities() {
        return  LocalAuthorityId;
    }
    public void setLocalAuthorities(String LocalAuthorityId) {
        this.LocalAuthorityId = LocalAuthorityId;
    }

    public String getRegionName() {
        return  RegionName;
    }
    public void setRegionName(String RegionName) {
        this.RegionName = RegionName;
    }




}


