package com.example.sunning.restauranthygienechecker;

import android.content.Intent;
import android.graphics.Color;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sunning.restauranthygienechecker.Adapters.ListViewAdapter;
import com.example.sunning.restauranthygienechecker.Interface.ApiInterface;
import com.example.sunning.restauranthygienechecker.Models.Establishment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class  ResultsActivity extends AppCompatActivity {
    private ListView listView;
    public static List<Establishment> results;
    private ApiInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Bundle extras = getIntent().getExtras();

        results = new ArrayList<>();
        String searchType = extras.getString("searchType");
        // String searchContent = extras.getString("searchContent");
        listView = findViewById(R.id.ShopListView);

        switch (searchType) {
            case "local":
                results = ApiInterface.getLocalEstablishments(SearchActivity.user);

                if (results != null) {
                    ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), results);
                    listView.setAdapter(adapter);
                }
                break;
            case "simple":
                String searchContent = extras.getString("searchContent");
                results = ApiInterface.getLocalEstablishments(searchContent);
                if (results != null) {
                    ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), results);
                    listView.setAdapter(adapter);
                }
                break;
            case "advanced":

                apiInterface = new ApiInterface();
                String searchBusinessName = extras.getString("searchBusinessName");
                String searchRegions = extras.getString("searchRegions");
                String searchBusinessTypes = extras.getString("searchBusinessTypes");
                String searchRatings = extras.getString("searchRatings");
                String searchDisRange = extras.getString("searchDisRange");

                results = apiInterface.getAdvancedEstablishments(searchBusinessName, searchRegions, searchBusinessTypes, searchRatings, searchDisRange);
                if (results != null) {
                    ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), results);
                    listView.setAdapter(adapter);
                }
                break;
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(ResultsActivity.this, DetailsActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });


    }
}
