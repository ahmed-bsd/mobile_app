package com.example.immoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button terrain ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        terrain = findViewById(R.id.terrain);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new HomeFragment()).commit();

        terrain.setOnClickListener(e ->{
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new TerrainFragment()).commit();
        });
    }
}