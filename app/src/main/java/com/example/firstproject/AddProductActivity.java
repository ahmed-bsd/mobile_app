package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.firstproject.AppDataBase.AppDataBase;
import com.example.firstproject.Entities.Annonce;

import java.util.ArrayList;
import java.util.List;

public class AddProductActivity extends AppCompatActivity {

    EditText Name,Prix,Categorie,Description;
    Button Annuler,Ok,Afficher;
    TextView tx;
    AppDataBase database ;
    private List<Annonce> AnnonceList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        database=AppDataBase.getInstance(this);

        Name=findViewById(R.id.nom);
        Prix=findViewById(R.id.prix);
        Categorie=findViewById(R.id.categorie);
        Description=findViewById(R.id.description);
        Annuler=findViewById(R.id.bouton_annuler);
        Ok=findViewById(R.id.bouton_ok);
        Afficher=findViewById(R.id.bouton_affiche);
        tx=findViewById(R.id.textView4);

        Ok.setOnClickListener(e->{
            //reccuperi l'annonce eli bch n'ajoutiwha
            Annonce annonce = new Annonce(Name.getText().toString(),Prix.getText().toString(),Categorie.getText().toString(),Description.getText().toString());
            //on fat l'apelle a la methode insert
            database.annonceDao().insertAnnonce(annonce);


        });
        Afficher.setOnClickListener(e->{
            String var="annonces from DB : *";
            AnnonceList = database.annonceDao().getAllAnnonce();

            for(Annonce a : AnnonceList){
                var+= a + " ";

            }
            tx.setText(var);

        });

        Annuler.setOnClickListener(e->{
            //pour appeller une autre activity on utilise le intent
            Intent intent = new Intent(this, ProductList.class);
            startActivity(intent);

        });



    }
}