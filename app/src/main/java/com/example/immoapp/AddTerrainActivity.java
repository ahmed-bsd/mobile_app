package com.example.immoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.immoapp.Dao.AppDataBase;
import com.example.immoapp.Entities.Terrain;

import java.util.List;

public class AddTerrainActivity extends AppCompatActivity {

    EditText nom,description,localisation;
    Button save, afficher;
    ImageView imageView;

    AppDataBase appDataBase;
    TextView tx;
    private static final int PICK_IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_terrain);

        nom = findViewById(R.id.nom);
        description = findViewById(R.id.description);
        localisation = findViewById(R.id.localisation);
        save= findViewById(R.id.save);
        afficher= findViewById(R.id.afficher);
        tx = findViewById(R.id.tx);
        imageView = findViewById(R.id.imageView);

        appDataBase=AppDataBase.getInstance(this);


        imageView.setOnClickListener(view -> {
            // Open the image picker
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PICK_IMAGE_REQUEST);
        });

        if (nom != null && description != null && localisation != null && save != null) {
            save.setOnClickListener(e -> {
                String nomText = nom.getText().toString();
                String descriptionText = description.getText().toString();
                String localisationText = localisation.getText().toString();

                int imageResourceId = R.drawable.image1; // Use a default image or fetch from your UI
                // Create a Terrain object with the input values
                Terrain terrain = new Terrain(nomText, descriptionText, localisationText,imageResourceId);

                // Insert the terrain into the database
                appDataBase.daoTerrain().insert(terrain);
            });
        }

        afficher.setOnClickListener(e->{
           List<Terrain> list= appDataBase.daoTerrain().getAll();
            String var= "terrains list : ";
           for(Terrain t : list){
               var+= t + " ";
           }
            tx.setText(var);
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null) {
            imageView.setImageURI(data.getData());
        }
    }
}