package com.example.adapteurlesson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class CustomizedAdapter extends AppCompatActivity {
    ListView customizedAdapterList;
    String[] notes = {"12", "14", "9"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customized_adapter);

        //BLock customized Adapter
        customizedAdapterList = findViewById(R.id.customizedAdapterList);
        customizedAdapterList.setAdapter(new CustomizedArrayAdapter(this, notes));
        customizedAdapterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO : add logic here
                String msg = (String) customizedAdapterList.getAdapter().getItem(position);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }
}