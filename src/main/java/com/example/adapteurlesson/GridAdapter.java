package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.GridView;

public class GridAdapter extends AppCompatActivity {

    GridView gridAdpater;
    String[] days;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_adapter);

        //get days list from main activity
        Intent intent = getIntent();
        days = intent.getStringArrayExtra("daysList");

        //Block Grid
        gridAdpater = findViewById(R.id.gridAdpaterList);
        gridAdpater.setAdapter(new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1,days
        ));
    }
}