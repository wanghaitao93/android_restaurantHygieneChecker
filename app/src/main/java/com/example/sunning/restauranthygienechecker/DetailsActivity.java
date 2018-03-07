package com.example.sunning.restauranthygienechecker;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.sunning.restauranthygienechecker.Models.Establishment;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

import org.json.JSONArray;


public class DetailsActivity extends AppCompatActivity implements OnMapReadyCallback {

    TextView tvEstName;
    TextView tvEstType;
    TextView tvEstAddress;
    TextView tvEstAuthority;
    TextView tvEstEmail;
    TextView tvFavorite;
    TextView tvFavorited;
    MapView mvEstPosition;
    Establishment establishment;

    private final int ACCESS_FINE_LOCATION = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Intent intent = getIntent();

        int position = intent.getIntExtra("position", 0);
        establishment = ResultsActivity.results.get(position);
        tvEstName = findViewById(R.id.tv_EstName);
        tvEstType = findViewById(R.id.tv_EstType);
        tvEstAddress = findViewById(R.id.tv_EstAddress);
        tvEstAuthority = findViewById(R.id.tv_EstAuthority);
        tvEstEmail = findViewById(R.id.tv_EstEmail);
        mvEstPosition = findViewById(R.id.mv_EstPosition);
        tvFavorite = findViewById(R.id.tv_favorite);
        tvFavorited = findViewById(R.id.tv_favorited);
        tvFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFavorited.setVisibility(View.VISIBLE);
                tvFavorite.setVisibility(View.GONE);
            }
        });
        tvFavorited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tvFavorite.setVisibility(View.VISIBLE);
                tvFavorited.setVisibility(View.GONE);
            }
        });

        tvEstName.setText(establishment.getBusinessName());
        tvEstType.setText(establishment.getBusinessType());
        tvEstAddress.setText(establishment.getAddressLine1());
        tvEstAuthority.setText(establishment.getLocalAuthorityName());
        tvEstEmail.setText(establishment.getLocalAuthorityEmailAddress());

        mvEstPosition.onCreate(savedInstanceState);
        mvEstPosition.onResume();
        if (mvEstPosition != null) {
            mvEstPosition.getMapAsync(this);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        mvEstPosition.onResume();
        mvEstPosition.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap map) {
        //DO WHATEVER YOU WANT WITH GOOGLEMAP
        map.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, ACCESS_FINE_LOCATION);
            return;
        } else {
            map.addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.location_pointer_logo))
                    .title(establishment.getBusinessName())
                    .position(new LatLng(Double.valueOf(establishment.getGeocode().getLatitude()), Double.valueOf(establishment.getGeocode().getLongitude()))));
            map.getUiSettings().setMyLocationButtonEnabled(true);
            map.setMyLocationEnabled(true);
            map.getUiSettings().setZoomControlsEnabled(true);
            map.setBuildingsEnabled(false);
            MapsInitializer.initialize(this);
            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(new LatLng(Double.valueOf(establishment.getGeocode().getLatitude()), Double.valueOf(establishment.getGeocode().getLongitude())));
            LatLngBounds bounds = builder.build();
            int padding = 0;
            int height = getResources().getDisplayMetrics().widthPixels;
            int width = 400;
            // Updates the location and zoom of the MapView
            CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, height, width, padding);
            map.moveCamera(cameraUpdate);
            cameraUpdate = CameraUpdateFactory.zoomTo(15);
            map.moveCamera(cameraUpdate);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case ACCESS_FINE_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    mvEstPosition.getMapAsync(this);
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request.
        }
    }


}
