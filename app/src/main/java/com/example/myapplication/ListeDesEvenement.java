package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class ListeDesEvenement extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_des_evenement);

        listView = findViewById(R.id.listview);
        //crate data
        ArrayList<evenement> arrayList = new ArrayList<>();

// Add an event to the ArrayList

        arrayList.add(new evenement(R.drawable.item, "Event Name 1", "Event Description 1", "25", "Location 1"));
        arrayList.add(new evenement(R.drawable.item2, "Event Name 2", "Event Description 2", "25", "Location 2"));
        arrayList.add(new evenement(R.drawable.item, "Event Name 3", "Event Description 3", "25/20/2022", "Location 3"));
        //we make custom adapter
        evenementAdapter evenementAdapter = new evenementAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(evenementAdapter);
        listView.setAdapter(evenementAdapter);
    }
    public void reserver(View view){
        startActivity(new Intent(ListeDesEvenement.this, formulaireevenmenet.class));
    }

}
