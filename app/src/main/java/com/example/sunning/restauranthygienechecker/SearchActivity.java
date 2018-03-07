package com.example.sunning.restauranthygienechecker;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.StrictMode;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sunning.restauranthygienechecker.Interface.ApiInterface;
import com.example.sunning.restauranthygienechecker.Interface.GpsTrackerInterface;
import com.example.sunning.restauranthygienechecker.Interface.SharedPreferencesInterface;
import com.example.sunning.restauranthygienechecker.Models.User;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class SearchActivity extends AppCompatActivity {
    private Button sBtnLocal;
    private ImageButton sBtnSimple;
    private Button sBtnFilter;
    private Button sBtnFavorite;
    public static User user;
    EditText searchContent;

    private FusedLocationProviderClient fusedLocationClient;

    private final int PERMISSION_REQUEST_FINE_LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        sBtnLocal = findViewById(R.id.btLocalSearch);
        sBtnSimple = findViewById(R.id.ibSimpleSearch);
        sBtnFilter = findViewById(R.id.btFilter);
        sBtnFavorite = findViewById(R.id.bt_favorite);
        searchContent =(EditText)findViewById(R.id.etSimpleSearch);

        final SharedPreferencesInterface sharedPreferences = new SharedPreferencesInterface(getApplicationContext());
        user = sharedPreferences.getUserSharedPreference();

        if (user == null) {
            user = new User();
        }
//        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
//
//        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//           ActivityCompat.requestPermissions(this,
//                   new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, PERMISSION_REQUEST_FINE_LOCATION);
//            return;
//        }
//
//        fusedLocationClient.getLastLocation()
//                .addOnSuccessListener(this, new OnSuccessListener<Location>() {
//                    @Override
//                    public void onSuccess(Location location) {
//                        // Got last known location. In some rare situations this can be null.
//                        if (location != null) {
//                           user.setLongitude(location.getLongitude());
//                           user.setLatitude(location.getLatitude());
//                           Log.d("USER_LONG", String.valueOf(user.getLongitude()));
//                           Log.d("USER_LAT", String.valueOf(user.getLatitude()));
//                           sharedPreferences.setUserSharedPreference(user);
//                        }
//                    }
//                });

        new ApiInterface();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        sBtnLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,ResultsActivity.class);
                intent.putExtra("searchType","local");
                startActivity(intent);
            }
        });

        sBtnSimple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,ResultsActivity.class);
                intent.putExtra("searchType","simple");
                intent.putExtra("searchContent", searchContent.getText().toString());
                startActivity(intent);
            }
        });

        sBtnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this, FilterActivity.class);
                startActivity(intent);
            }
        });

        sBtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchActivity.this,FilterActivity.class);
                startActivity(intent);
            }
        });
    }
}

