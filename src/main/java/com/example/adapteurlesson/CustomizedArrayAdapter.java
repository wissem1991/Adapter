package com.example.adapteurlesson;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomizedArrayAdapter extends ArrayAdapter {
    Activity context;
    String[] data;

    CustomizedArrayAdapter(Activity context, String[] data){
        super(context, R.layout.customized_adapter_layout, data);
        this.context = context;
        this.data = data;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View ligne = inflater.inflate(R.layout.customized_adapter_layout,null);
        TextView note = ligne.findViewById(R.id.note);
        ImageView icone = ligne.findViewById(R.id.icone);
        String itemValue = data[position];
        note.setText(itemValue);
        if (Integer.parseInt(itemValue) >= 10) {
            icone.setImageResource(R.drawable.good);
        } else {
            icone.setImageResource(R.drawable.bad);
        }

        return ligne;
    }
}
