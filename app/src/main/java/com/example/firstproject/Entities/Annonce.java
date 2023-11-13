package com.example.firstproject.Entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Annonce_table")
public class Annonce {

    @PrimaryKey(autoGenerate = true)
    private int idAnnonce;
    @ColumnInfo(name = "NomAnnonce")
    private String NomAnnonce;
    @ColumnInfo(name = "PrixAnnonce")
    private String PrixAnnonce;
    @ColumnInfo(name = "Categorie")
    private String Categorie;
    @ColumnInfo(name = "Description")
    private String Description;

    public Annonce() {
    }

    public Annonce(String nomAnnonce, String prixAnnonce, String categorie, String description) {
        NomAnnonce = nomAnnonce;
        PrixAnnonce = prixAnnonce;
        Categorie = categorie;
        Description = description;
    }

    public Annonce(String nomAnnonce) {
        NomAnnonce = nomAnnonce;
    }

    public Annonce(int idAnnonce, String nomAnnonce, String prixAnnonce, String categorie, String description) {
        this.idAnnonce = idAnnonce;
        NomAnnonce = nomAnnonce;
        PrixAnnonce = prixAnnonce;
        Categorie = categorie;
        Description = description;
    }

    public int getIdAnnonce() {
        return idAnnonce;
    }

    public void setIdAnnonce(int idAnnonce) {
        this.idAnnonce = idAnnonce;
    }

    public String getNomAnnonce() {
        return NomAnnonce;
    }

    public void setNomAnnonce(String nomAnnonce) {
        NomAnnonce = nomAnnonce;
    }

    public String getPrixAnnonce() {
        return PrixAnnonce;
    }

    public void setPrixAnnonce(String prixAnnonce) {
        PrixAnnonce = prixAnnonce;
    }

    public String getCategorie() {
        return Categorie;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return "Annonce{" +
                "idAnnonce=" + idAnnonce +
                ", NomAnnonce='" + NomAnnonce + '\'' +
                ", PrixAnnonce='" + PrixAnnonce + '\'' +
                ", Categorie='" + Categorie + '\'' +
                ", Description='" + Description + '\'' +
                '}';
    }
}
