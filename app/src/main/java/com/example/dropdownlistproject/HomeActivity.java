package com.example.dropdownlistproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private RecyclerView recyecle_view;
    private CountryAdapter mCountryAdapter;
    ArrayList<String> adapterList = new ArrayList<String>();
    ArrayList<SpinnerModel> listVOs = new ArrayList<>();
    final String[] select_qualification = {
            "Select Qualification","7th", "8th","9th","10th","11th", "12th", "Diploma", "UG",
            "PG", "Phd"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        for (int i = 0; i < select_qualification.length; i++) {
            SpinnerModel stateVO = new SpinnerModel();
            stateVO.setTitle(select_qualification[i]);
            listVOs.add(stateVO);
        }

        adapterList.add("Spinner One");
        adapterList.add("Spinner Two");
        adapterList.add("Spinner Three");
        adapterList.add("Spinner Four");
        adapterList.add("Spinner Five");
        adapterList.add("Spinner Six");
        adapterList.add("Spinner Seven");
        adapterList.add("Spinner Eight");
        adapterList.add("Spinner Nine");
        adapterList.add("Spinner Ten");
        adapterList.add("Spinner Eleven");


        mCountryAdapter=new CountryAdapter();
        recyecle_view=findViewById(R.id.recycleview);
        recyecle_view.setLayoutManager(new LinearLayoutManager(this));
        recyecle_view.setAdapter(mCountryAdapter);
        mCountryAdapter.update(adapterList,listVOs);

    }
}
