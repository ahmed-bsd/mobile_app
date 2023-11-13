package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import com.example.firstproject.AppDataBase.AppDataBase;
import com.example.firstproject.Entities.Annonce;

import java.util.ArrayList;
import java.util.List;


public class ProductItem extends AppCompatActivity {
    private AppDataBase database;
    private List<Annonce> annonceList = new ArrayList<>();



    Button details,delete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_item);

        details = findViewById(R.id.detailsButton);
        details.setOnClickListener(e ->{


            //int annonceId = 1;

            // Créez un intent pour démarrer l'activité des détails
            Intent intent = new Intent(this, DetailsActivity.class);

            // Ajoutez l'ID de l'annonce à l'intent
           // intent.putExtra("ANNONCE_ID", annonceId);

            // Démarrer l'activité des détails
            startActivity(intent);

        });


    }
}

