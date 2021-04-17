package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class AutoCompleteAdapter extends AppCompatActivity {
    AutoCompleteTextView autoCompleteTextView;
    String[] days;
    TextView selectedAutocompleteItem;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto_complete_adapter);

        selectedAutocompleteItem = findViewById(R.id.selectedAutocompleteItem);

        //get days list from main activity
        Intent intent = getIntent();
        days = intent.getStringArrayExtra("daysList");

        //Block Autocomplete
        autoCompleteTextView =(AutoCompleteTextView) findViewById(R.id.autoCompleteList);
        ArrayAdapter<String> AutoCompleteAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                days
        );

        //Block autocomplete adapter
        autoCompleteTextView.setAdapter(AutoCompleteAdapter);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String msg = (String) autoCompleteTextView.getAdapter().getItem(position);
                selectedAutocompleteItem.setText("Vous avez séléctionner le :"+ msg);
            }
        });
    }
}