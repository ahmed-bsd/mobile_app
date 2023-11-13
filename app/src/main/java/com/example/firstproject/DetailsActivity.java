package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.firstproject.AppDataBase.AppDataBase;
import com.example.firstproject.Entities.Annonce;

public class DetailsActivity extends AppCompatActivity {

    AppDataBase appDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Récupérez l'ID de l'annonce de l'intent
        int annonceId = getIntent().getIntExtra("ANNONCE_ID", -1);

        // Utilisez l'ID pour obtenir les détails de l'annonce depuis la base de données
       AppDataBase appDataBase = AppDataBase.getInstance(this);
        Annonce annonce = appDataBase.annonceDao().getAnnonceById(annonceId);

        // Affichez les détails dans les TextView appropriés
        TextView nomAnnonceTextView = findViewById(R.id.nomAnnonceTextView);
        TextView prixAnnonceTextView = findViewById(R.id.prixAnnonceTextView);
        TextView categorieTextView = findViewById(R.id.categorieTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);

        nomAnnonceTextView.setText(annonce.getNomAnnonce());
        prixAnnonceTextView.setText("Prix : " + annonce.getPrixAnnonce() + " dt");
        categorieTextView.setText("Catégorie : " + annonce.getCategorie());
        descriptionTextView.setText("Description : " + annonce.getDescription());

    }
}