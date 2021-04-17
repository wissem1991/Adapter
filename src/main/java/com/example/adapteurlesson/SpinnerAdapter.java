package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class SpinnerAdapter extends AppCompatActivity {
    Spinner spinner;
    String[] days;
    TextView selectedItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_adapter);

        selectedItem = findViewById(R.id.selectedSpinnerItem);
        //get days list from main activity
        Intent intent = getIntent();
        days = intent.getStringArrayExtra("daysList");

        //Block Spinner Adapter
        spinner = findViewById(R.id.spinnerList);
        ArrayAdapter<String> daysSpinnerAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, days
        );
        daysSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(daysSpinnerAdapter);
        spinner.setSelection(0, false);//Disable default selected Item
        spinner.setOnItemSelectedListener(daysSpinnerAdapterSelected);
    }

    private AdapterView.OnItemSelectedListener daysSpinnerAdapterSelected = new AdapterView.OnItemSelectedListener(){
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //TODO : add on selected item logic here
            selectedItem.setText(days[position]);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            //TODO : add default logic here
        }
    };
}