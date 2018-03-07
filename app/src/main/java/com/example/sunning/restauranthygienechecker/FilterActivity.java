package com.example.sunning.restauranthygienechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import com.example.sunning.restauranthygienechecker.Interface.ApiInterface;
import com.example.sunning.restauranthygienechecker.Models.BusinessTypes;
import com.example.sunning.restauranthygienechecker.Models.Countries;
import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {

    // filter button
    private Button sBtnFilter1;

    // Countries
    private Spinner spinner_Countries;
    private List<String> list_Countries;
    private ArrayAdapter<String> adapter_Countries;
    private List<Countries> Countries;

    // business type
    private Spinner spinner_business_type;
    private List<String> list_business_type;
    private ArrayAdapter<String> adapter_business_type;
    private List<BusinessTypes> businessTypes;

    // rating
    private Spinner spinner_rating;
    private ArrayAdapter<String> adapter_rating;
    private ArrayList<String> list_rating;

    // distance range
    private Spinner spinner_distance_type;
    private ArrayAdapter<String> adapter_disRange;
    private ArrayList<String> list_disRange;



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);


        // filter button and set button clickListener
        sBtnFilter1 = findViewById(R.id.btFilter1);
        sBtnFilter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int CountriesIndex = spinner_Countries.getSelectedItemPosition();
                int businessTypesIndex = spinner_business_type.getSelectedItemPosition();
                int ragingsIndex = spinner_rating.getSelectedItemPosition();
                int disRangeIndex = spinner_distance_type.getSelectedItemPosition();

                String CountriesId = "All", businessTypeId = "All", ratingsId = "All", disRangeId = "All";

                if (CountriesIndex != 0){
                    CountriesId = Countries.get(CountriesIndex).getCountriesId().toString();
                }

                if (businessTypesIndex != 0){
                    businessTypeId = businessTypes.get(businessTypesIndex).getBusinessTypeId().toString();
                }

                if (ragingsIndex != 0){
                    ratingsId = Integer.toString(ragingsIndex);
                }

                if (disRangeIndex != 0){
                    disRangeId = Integer.toString(disRangeIndex);
                }

                Intent intent = new Intent(FilterActivity.this, ResultsActivity.class);
                intent.putExtra("searchType","advanced");
                intent.putExtra("searchCountries", CountriesId);
                intent.putExtra("searchBusinessTypes", businessTypeId);
                intent.putExtra("searchRatings", ratingsId);
                intent.putExtra("searchDisRange", disRangeId);
                startActivity(intent);
            }
        });


        // business_type spinner
        downCountriesDatas();
        spinner_Countries = findViewById(R.id.Spinner_Countries);
        adapter_Countries = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_Countries);
        adapter_Countries.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_Countries.setAdapter(adapter_Countries);

        // Countries spinner
        downBusinessTypeDatas();
        spinner_business_type = findViewById(R.id.Spinner_BusinessType);
        adapter_business_type = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_business_type);
        adapter_business_type.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_business_type.setAdapter(adapter_business_type);

        // rating spinner
        initRatings();
        spinner_rating = findViewById(R.id.Spinner_Rating);
        adapter_rating = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_rating);
        adapter_rating.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_rating.setAdapter(adapter_rating);

        // distance range spinder
        initdisRange();
        spinner_distance_type = findViewById(R.id.Spinner_DistanceRange);
        adapter_disRange = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_disRange);
        adapter_disRange.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_distance_type.setAdapter(adapter_disRange);
    }


    // download Countries datas from website
    private void downCountriesDatas()
    {
        Countries = ApiInterface.getCountriesType();
        System.out.println("Countries size : " + Countries.size());
        list_Countries = new ArrayList<String>();
        list_Countries.add("All");
        for(int i = 0; i < Countries.size(); i++)
        {
            list_Countries.add(Countries.get(i).getCountriesName());
        }
    }

    // download BusinessType datas from website
    private void downBusinessTypeDatas()
    {
        businessTypes = ApiInterface.getBusinessTypes();
        System.out.println("BusinessType size : " + businessTypes.size());
        list_business_type = new ArrayList<String>();
        for(int i = 0; i < businessTypes.size(); i++)
        {
            list_business_type.add(businessTypes.get(i).getBusinessTypeName());
        }
    }

    // initial ratings category
    private void initRatings(){
        list_rating = new ArrayList<String>();
        list_rating.add("All");
        list_rating.add("1 rating");
        list_rating.add("2 rating");
        list_rating.add("3 rating");
        list_rating.add("4 rating");
        list_rating.add("5 rating");

    }

    // initial max distance category
    private void initdisRange(){
        list_disRange = new ArrayList<String>();
        list_disRange.add("All");
        list_disRange.add("1 miles");
        list_disRange.add("2 miles");
        list_disRange.add("3 miles");
        list_disRange.add("4 miles");
        list_disRange.add("5 miles");
        list_disRange.add("6 miles");
        list_disRange.add("7 miles");
        list_disRange.add("8 miles");

    }

}
