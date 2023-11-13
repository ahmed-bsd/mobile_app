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



public class formulaireevenmenet extends AppCompatActivity {
    private EditText nameEditText;
    private EditText phoneEditText;
    private EditText emailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulaireevenmenet);

        Intent intent = getIntent();
        String selectedEvent = intent.getStringExtra("selectedEvent");

        nameEditText = findViewById(R.id.name);
        phoneEditText = findViewById(R.id.phone);
        emailEditText = findViewById(R.id.email);

        Button reserveButton = findViewById(R.id.reserveButton);
        reserveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEditText.getText().toString();
                String phone = phoneEditText.getText().toString();
                String email = emailEditText.getText().toString();

                if (isValidInput(name, phone, email)) {
                    ReservationsManager.ajouterReservation(new Reservation(name, phone, email));
                    openGestionnaireReservation();
                    //Intent detailIntent = new Intent(formulaireevenmenet.this, gestionReservation.class);
                  //  detailIntent.putExtra("selectedEvent", selectedEvent);
                   // detailIntent.putExtra("nom", name);
                  //  detailIntent.putExtra("numTel", phone);
                 //   detailIntent.putExtra("mail", email);
                  //  startActivity(detailIntent);
                } else {
                    // Gérer le cas où les entrées ne sont pas valides
                    Toast.makeText(formulaireevenmenet.this, "Veuillez remplir tous les champs correctement.", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    private void openGestionnaireReservation() {
        Intent intent = new Intent(this, gestionReservation.class);
        startActivity(intent);
    }
    private boolean isValidInput(String name, String phone, String email) {
        // Ajoutez ici vos propres validations
        return !name.isEmpty() && !phone.isEmpty() && !email.isEmpty();
    }



}