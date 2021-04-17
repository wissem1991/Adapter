package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button listAdapterBtn;
    String[] days = {"Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche"};

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listAdapterBtn = findViewById(R.id.listAdapterBtn);
    }

    public void redirctTo(View view){
        Intent intent;
        String clickedActivity = (String) view.getTag();
        switch (clickedActivity) {
            case "spinner":
                intent = new Intent(this, SpinnerAdapter.class);
                break;
            case "list":
                intent = new Intent(this, ListAdapter.class);
                break;
            case "autocomplete":
                intent = new Intent(this, AutoCompleteAdapter.class);
                break;
            case "grid":
                intent = new Intent(this, GridAdapter.class);
                break;
            case "customized":
                intent = new Intent(this, CustomizedAdapter.class);
                break;
            default:
                intent = new Intent();
        }
        intent.putExtra("daysList", days);
        startActivity(intent);
    }
}