package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservationdetail);

        Intent intent = getIntent();
        Reservation reservation = (Reservation) intent.getSerializableExtra("reservation");

        // Affichez les détails de la réservation dans votre mise en page
        if (reservation != null) {
            TextView detailsTextView = findViewById(R.id.name);
            detailsTextView.setText(reservation.toString());
        }



        Button modifierButton = findViewById(R.id.modifierButton);
        modifierButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIntent = new Intent(ReservationDetailActivity.this, formulaireevenmenetModif.class);
                detailIntent.putExtra("modification", true);
                detailIntent.putExtra("reservation", reservation);
                startActivity(detailIntent);
            }
        });

        Button supprimerButton = findViewById(R.id.supprimerButton);
        supprimerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Ajoutez ici le code pour supprimer l'événement
                ReservationsManager.supprimerReservation(reservation); // Assurez-vous d'ajouter une méthode similaire dans ReservationsManager
                // Ensuite, terminez l'activité
                finish();
            }
        });
    }

}