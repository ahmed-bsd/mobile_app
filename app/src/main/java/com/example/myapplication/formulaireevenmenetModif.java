package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class formulaireevenmenetModif extends AppCompatActivity {

    private boolean modification;
    private Reservation reservation;
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaireevenmenetmodif);

        Intent intent = getIntent();
        modification = intent.getBooleanExtra("modification", false);
        reservation = (Reservation) intent.getSerializableExtra("reservation");

        nameEditText = findViewById(R.id.name);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);



        Button sauvgarderButton = findViewById(R.id.sauvgarderButton);
        sauvgarderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                modifierEvenement();
            }
        });
    }

    private void modifierEvenement() {
        EditText nameEditText = findViewById(R.id.name);
        String nouveaunom = nameEditText.getText().toString();

        EditText phoneEditText = findViewById(R.id.phone);
        String nouveauphone = phoneEditText.getText().toString();

        EditText emailEditText = findViewById(R.id.email);
        String nouveauemail = emailEditText.getText().toString();
        // Ajoutez ici la logique pour sauvegarder les modifications (par exemple, dans une base de données)

        // Retournez les données modifiées à l'activité DetailEvenementActivity
        Reservation nouvelleReservation;
        if (modification && reservation != null) {
            // Modification de la réservation existante
            nouvelleReservation = new Reservation(nouveaunom, nouveauphone, nouveauemail);
        } else {
            // Ajout d'une nouvelle réservation
            nouvelleReservation = new Reservation(nouveaunom, nouveauphone, nouveauemail);
            ReservationsManager.ajouterReservation(nouvelleReservation);
        }

        // Fermez l'activité après avoir sauvegardé les modifications
        finish();
    }




}
