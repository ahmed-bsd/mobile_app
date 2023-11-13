package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class gestionReservation extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestionreservation);

        List<Reservation> reservations = ReservationsManager.getReservations();

        ListView reservationsListView = findViewById(R.id.reservationsListView);

        List<String> reservationsDetails = createReservationsDetails(reservations);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, reservationsDetails);
        reservationsListView.setAdapter(adapter);

        // ...

        reservationsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Obtenez la réservation sélectionnée
                Reservation selectedReservation = reservations.get(position);

                // Lancez une nouvelle activité (DetailReservationActivity) avec les détails de la réservation
                Intent intent = new Intent(gestionReservation.this, ReservationDetailActivity.class);
                intent.putExtra("reservation", selectedReservation);
                startActivity(intent);
            }
        });
    }

// Add an event to the ArrayList


    private List<String> createReservationsDetails(List<Reservation> reservations) {
        List<String> reservationsDetails = new ArrayList<>();
        for (Reservation reservation : reservations) {
            reservationsDetails.add(reservation.toString());
        }
        return reservationsDetails;
    }
    public void Detail(View view){
        startActivity(new Intent(gestionReservation.this, ReservationDetailActivity.class));
    }

}

