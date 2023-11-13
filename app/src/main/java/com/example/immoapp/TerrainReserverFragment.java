package com.example.immoapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;


public class TerrainReserverFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_terrain_reserver, container, false);

        ImageView terrainImage = view.findViewById(R.id.image);
        TextInputEditText nomEditText = view.findViewById(R.id.nameInput);
        TextInputEditText prenomEditText = view.findViewById(R.id.prenomInput);
        TextInputEditText emailEditText = view.findViewById(R.id.email);
        TextInputEditText telephoneEditText = view.findViewById(R.id.phone);
        CheckBox rappelCheckBox = view.findViewById(R.id.rappel);
        DatePicker datePicker = view.findViewById(R.id.datePicker);
        TimePicker timePicker = view.findViewById(R.id.timePicker);
        Button reserverButton = view.findViewById(R.id.reservation);

        // on doit configurer le DatePicker pour permettre la selection
        datePicker.setDescendantFocusability(DatePicker.FOCUS_BLOCK_DESCENDANTS);
        reserverButton.setOnClickListener(v -> {
            // recuperation de la date selectionnee
            int year = datePicker.getYear();
            int month = datePicker.getMonth();
            int dayOfMonth = datePicker.getDayOfMonth();

            // Rde meme pour lheure
            int hourOfDay = timePicker.getHour();
            int minute = timePicker.getMinute();

            // Faire ce que vous devez avec la date et l'heure sélectionnées
            String reservationDateTime = String.format("%d-%02d-%02d %02d:%02d", year, month + 1, dayOfMonth, hourOfDay, minute);
            // Récupérer les informations du formulaire
            String nom = nomEditText.getText().toString();
            String prenom = prenomEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String telephone = telephoneEditText.getText().toString();

            // Afficher la notification (Snackbar)
            String message = String.format("Monsieur %s, votre réservation pour le %s à %s est bien enregistrée. Vous recevrez un email de confirmation. Merci!",
                    nom, formatDate(dayOfMonth, month + 1, year), formatTime(hourOfDay, minute));
            Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show();
        });




        return view;


    }
    private String formatDate(int day, int month, int year) {
        return String.format("%02d/%02d/%d", day, month, year);
    }

    private String formatTime(int hour, int minute) {
        return String.format("%02d:%02d", hour, minute);
    }
}