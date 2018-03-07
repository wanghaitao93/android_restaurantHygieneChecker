package com.example.sunning.restauranthygienechecker.Interface;

import com.example.sunning.restauranthygienechecker.Models.Authorities;
import com.example.sunning.restauranthygienechecker.Models.BusinessTypes;
import com.example.sunning.restauranthygienechecker.Models.Establishment;
import com.example.sunning.restauranthygienechecker.Models.Regions;
import com.example.sunning.restauranthygienechecker.Models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.List;

public class ApiInterface {

    private static String baseUrl = "http://api.ratings.food.gov.uk";
    private static HttpHeaders headers;
    private static RestTemplate rest;
    private static HttpEntity<String> requestEntity;

    public ApiInterface() {
        headers = new HttpHeaders();
        headers.add("x-api-version", "2");
        headers.add("Content-Type", "application/json");
        rest = new RestTemplate();
        requestEntity = new HttpEntity<>(headers);
    }


    public static List<Establishment> getLocalEstablishments(User user) {
        double latitude = 52.477646; // replace with 'user.getLatitude();'
        double longitude = -1.903746; // replace with 'user.getLongitude();'
        List<Establishment> results = new ArrayList<>();
        String queryUrl = baseUrl + "/Establishments?latitude=" + String.valueOf(latitude) + "&longitude=" + String.valueOf(longitude) + "&maxDistanceLimit=1&pageNumber=1&pageSize=15";

        try {
            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();
            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("establishments");
            String result = resultArr.toString();
            results = new Gson().fromJson(result, new TypeToken<List<Establishment>>() {
            }.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return results;
        }
    }

    public static List<Establishment> getLocalEstablishments(String searchContent) {
        String queryUrl = baseUrl + "/Establishments?name=" + String.valueOf(searchContent) + "&maxDistanceLimit=1&pageNumber=1&pageSize=15";

        try {
            List<Establishment> results = new ArrayList<>();

            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();
            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("establishments");
            String result = resultArr.toString();
            results = new Gson().fromJson(result, new TypeToken<List<Establishment>>() {
            }.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // acquire Regions name from website
    public static List<Regions> getRegionsType() {

        String queryUrl = baseUrl + "/Regions/basic";

        try {

            List<Regions> results = new ArrayList<>();
            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();

            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("regions");
            String result = resultArr.toString();

            results = new Gson().fromJson(result, new TypeToken<List<Regions>>() {}.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    // acquire authorities  from website
    public static List<Authorities> getAuthorities() {
        String queryUrl = baseUrl + "/Authorities";
        try {

            List<Authorities> results = new ArrayList<>();
            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();

            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("authorities");
            String result = resultArr.toString();

            results = new Gson().fromJson(result, new TypeToken<List<Authorities>>() {}.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
    // acquire business type name from website
    public static List<BusinessTypes> getBusinessTypes() {

        String queryUrl = baseUrl + "/BusinessTypes/basic";

        try {

            List<BusinessTypes> results = new ArrayList<>();
            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();

            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("businessTypes");
            String result = resultArr.toString();

            results = new Gson().fromJson(result, new TypeToken<List<BusinessTypes>>() {}.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }


    // advanced search
    public static List<Establishment> getAdvancedEstablishments(String searchBusinessName, String searchRegions, String searchBusinessTypes, String searchRatings, String searchDisRange) {

        String queryUrl = baseUrl + "/Establishments?pageNumber=1&pageSize=10";
        String filterStr = "";

        // Business Name
        if(!searchBusinessName.equals("All")){
            filterStr += "&name=\"" + searchBusinessName + "\"";
        }

        // Regions
        if (!searchRegions.equals("All")){
            filterStr += "&localAuthorityId=" + searchRegions;
        }

        // business
        if (!searchBusinessTypes.equals("All")){
            filterStr += "&businessTypeId=" + searchBusinessTypes;
        }

        // rating
        if (!searchRatings.equals("All")){
            filterStr += "&ratingKey=" + searchRatings;
        }

        // disRange
        if (!searchDisRange.equals("All")){
            filterStr += "&maxDistanceLimit=" + searchDisRange;
        }

        queryUrl += filterStr;

        System.out.println("queryUrl url : " + queryUrl);

        try {
            List<Establishment> results = new ArrayList<>();

            ResponseEntity<String> responseEntity = rest.exchange(queryUrl, HttpMethod.GET, requestEntity, String.class);
            String response = responseEntity.getBody();
            JSONObject object = new JSONObject(response);
            JSONArray resultArr = object.getJSONArray("establishments");
            String result = resultArr.toString();
            results = new Gson().fromJson(result, new TypeToken<List<Establishment>>() {
            }.getType());
            return results;

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
