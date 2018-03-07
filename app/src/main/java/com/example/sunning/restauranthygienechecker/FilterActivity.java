package com.example.sunning.restauranthygienechecker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import com.example.sunning.restauranthygienechecker.Interface.ApiInterface;
import com.example.sunning.restauranthygienechecker.Models.BusinessTypes;
import com.example.sunning.restauranthygienechecker.Models.Regions;
import com.example.sunning.restauranthygienechecker.Models.Authorities;

import java.util.ArrayList;
import java.util.List;

public class FilterActivity extends AppCompatActivity {

    // filter button
    private Button sBtnFilter1;

    // business name editview
    private EditText searchContent;

    // Regions
    private Spinner spinner_Regions;
    private List<String> list_Regions;
    private ArrayAdapter<String> adapter_Regions;
    private List<Regions> Regions;

    // Authorities
    private Spinner spinner_Authorities;
    private List<String> list_Authorities;
    private  ArrayAdapter<String> adapter_Authorities;
    private List<Authorities> Authorities;


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


        // business name edittext
        searchContent =(EditText)findViewById(R.id.evBusinessName);

        // filter button and set button clickListener
        sBtnFilter1 = findViewById(R.id.btFilter1);
        sBtnFilter1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {

                String BusinessNameStr = searchContent.getText().toString();
                System.out.println("BusinessNameStr : " + BusinessNameStr);
                int AuthoritiesIndex = spinner_Authorities.getSelectedItemPosition();
                int businessTypesIndex = spinner_business_type.getSelectedItemPosition();
                int ragingsIndex = spinner_rating.getSelectedItemPosition();
                int disRangeIndex = spinner_distance_type.getSelectedItemPosition();

                if (BusinessNameStr.equals(""))
                {
                    BusinessNameStr = "All";
                }

                String AuthoritiesId = "All", businessTypeId = "All", ratingsId = "All", disRangeId = "All";

                if (AuthoritiesIndex != 0){
                    AuthoritiesId = Authorities.get(AuthoritiesIndex).getLocalAuthorities().toString();
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
                intent.putExtra("searchBusinessName", BusinessNameStr);
                intent.putExtra("searchRegions", AuthoritiesId);
                intent.putExtra("searchBusinessTypes", businessTypeId);
                intent.putExtra("searchRatings", ratingsId);
                intent.putExtra("searchDisRange", disRangeId);
                startActivity(intent);
            }
        });


        // business_type spinner
        initRegionsDatas();
        spinner_Regions = findViewById(R.id.Spinner_Regions);
        adapter_Regions = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_Regions);
        adapter_Regions.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_Regions.setAdapter(adapter_Regions);

        // Regions spinner
        initBusinessTypeDatas();
        spinner_business_type = findViewById(R.id.Spinner_BusinessType);
        adapter_business_type = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_business_type);
        adapter_business_type.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_business_type.setAdapter(adapter_business_type);

        spinner_Regions.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                if (position != 0){
                    String regionName = Regions.get(position).getRegionsName().toString();
                    setAuthoritiesAdapter(regionName);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        // Authorities spinner
        spinner_Authorities = findViewById(R.id.Spinner_Authorities);
        initAuthoritiesData();

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


    // download Regions datas from website
    private void initRegionsDatas()
    {
        Regions = ApiInterface.getRegionsType();
        System.out.println("Regions size : " + Regions.size());
        list_Regions = new ArrayList<String>();
        list_Regions.add("All");
        for(int i = 0; i < Regions.size(); i++)
        {
            list_Regions.add(Regions.get(i).getRegionsName());
        }
    }

    // down Authorities datas from website
    private void initAuthoritiesData()
    {
        Authorities = ApiInterface.getAuthorities();
        System.out.println("Authorities size : " + Authorities.size());
        list_Authorities = new ArrayList<String>();
        list_Authorities.add("All");

        adapter_Authorities = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_Authorities);
        adapter_Authorities.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_Authorities.setAdapter(adapter_Authorities);

    }

    private void setAuthoritiesAdapter(String regionName)
    {
        list_Authorities.clear();
        list_Authorities.add("All");
        for (int i = 0; i < Authorities.size(); i++)
        {
            if (Authorities.get(i).getRegionName().equals(regionName))
            {
                list_Authorities.add(Authorities.get(i).getAuthoritiesName());
            }
        }
        adapter_Authorities = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list_Authorities);
        adapter_Authorities.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner_Authorities.setAdapter(adapter_Authorities);
    }
    // download BusinessType datas from website
    private void initBusinessTypeDatas()
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
