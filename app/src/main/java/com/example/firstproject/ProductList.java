package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.firstproject.AppDataBase.AppDataBase;
import com.example.firstproject.Entities.Annonce;

import java.util.ArrayList;
import java.util.List;

public class ProductList extends AppCompatActivity {


    private List<Annonce> userList = new ArrayList<>();
    Button button2;
    private AppDataBase appDataBase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        ListView productListView = findViewById(R.id.productListView);
        button2 = findViewById(R.id.Button2);

        appDataBase = AppDataBase.getInstance(this);

        // Obtenez la liste de produits depuis la base de données
        List<Annonce> AnnonceList = appDataBase.annonceDao().getAllAnnonce(); // Assurez-vous d'avoir une méthode appropriée dans votre DAO

        // Convertissez la liste de produits en une liste de noms de produits (à adapter selon votre modèle de données)
        List<String> AnnonceNames = new ArrayList<>();
        List<String> AnnonceDetails = new ArrayList<>();

        for (Annonce annonce : AnnonceList) {
            AnnonceNames.add(annonce.getNomAnnonce());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.activity_product_item, R.id.productName, AnnonceNames);
        productListView.setAdapter(adapter);

         /* for (Annonce annonce : AnnonceList) {
            // Concaténez le nom et le prix dans une seule chaîne
            String details = annonce.getNomAnnonce() + " - " + annonce.getPrixAnnonce();
            AnnonceDetails.add(details);
            AnnonceAdapter adapter2 = new AnnonceAdapter(this, R.layout.activity_product_item, AnnonceDetails);
            productListView.setAdapter(adapter2);
        }*/





        button2.setOnClickListener(e -> {
            //pour appeller une autre activity on utilise le intent
            Intent intent = new Intent(this, AddProductActivity.class);
            startActivity(intent);
        });
    }








    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return true;
    }
}


