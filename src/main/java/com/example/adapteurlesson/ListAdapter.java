package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class ListAdapter extends AppCompatActivity {

    ListView daysList;
    String[] days;
    TextView selectedItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_adapter);
        selectedItem = findViewById(R.id.slectedElement);

        //get days list from main activity
        Intent intent = getIntent();
        days = intent.getStringArrayExtra("daysList");

        //block bouton back
        Button backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        //Block Adapteur list
        daysList = findViewById(R.id.listDays);
        ArrayAdapter<String> daysListAdapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, days
        );
        daysList.setAdapter(daysListAdapter);
        daysList.setOnItemClickListener(daysListAdapterClick);
    }

    private AdapterView.OnItemClickListener daysListAdapterClick = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectedItem.setText(days[position]);
        }
    };
}