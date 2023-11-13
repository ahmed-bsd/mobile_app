package com.example.myapplication;
import java.io.Serializable;

public class Reservation implements Serializable {

        private String nom;
        private String numTel;
        private String mail;

        public Reservation(String nom, String numTel, String mail) {
            this.nom = nom;
            this.numTel = numTel;
            this.mail = mail;
        }

        @Override
        public String toString() {
            return "Nom: " + nom + "\nNuméro de téléphone: " + numTel + "\nAdresse e-mail: " + mail;
        }
    }


