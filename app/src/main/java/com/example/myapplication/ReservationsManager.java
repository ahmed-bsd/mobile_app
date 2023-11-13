package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.Reservation;

import java.util.ArrayList;
import java.util.List;
public class ReservationsManager {


        private static List<Reservation> reservations = new ArrayList<>();

        public static void ajouterReservation(Reservation reservation) {
            reservations.add(reservation);
        }

        public static List<Reservation> getReservations() {
            return reservations;
        }
    public static void supprimerReservation(Reservation reservation) {
        try {
            reservations.remove(reservation);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }


