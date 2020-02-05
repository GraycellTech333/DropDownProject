package com.example.dropdownlistproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Spinner mSpinner;
    final String[] select_qualification = {
            "Select Qualification", "10th / Below", "12th", "Diploma", "UG",
            "PG", "Phd"};
    ArrayList<SpinnerModel> listVOs = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        mSpinner = findViewById(R.id.spinner);

        for (int i = 0; i < select_qualification.length; i++) {
            SpinnerModel stateVO = new SpinnerModel();
            stateVO.setTitle(select_qualification[i]);
            listVOs.add(stateVO);
        }
        MyAdapter myAdapter = new MyAdapter(this, 0,
                listVOs);
        mSpinner.setAdapter(myAdapter);

        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                SpinnerModel selectedItem = (SpinnerModel) parent.getItemAtPosition(position);
                Log.e("SelectedItem",""+selectedItem.getTitle());

            } // to close the onItemSelected
            public void onNothingSelected(AdapterView<?> parent)
            {

            }
        });
    }
}
