package com.example.gpsmenu_new;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormatSymbols;

public class MainActivity extends AppCompatActivity {

    Spinner spinner1 = findViewById(R.id.spinner1);
    Spinner spinner2 = findViewById(R.id.spinner2);
    Button btn = findViewById(R.id.btn);
    String[] states;

    @Override
        public void onCreate (Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            populateState();
            populateCity();
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String States = spinner1.getSelectedItem().toString();
                    String Cities = spinner2.getSelectedItem().toString();
                   Toast.makeText(MainActivity.this, States + ", " + Cities, Toast.LENGTH_SHORT).show();
                }
            });
    }

    private void populateState() {
        ArrayAdapter<String> state = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.States));
        state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(state);
        }

     private void populateCity() {
         ArrayAdapter<String> city = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, getResources().getStringArray(R.array.Cities));
         city.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
         spinner2.setAdapter(city);
     }
}



