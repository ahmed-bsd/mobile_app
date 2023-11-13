package com.example.immoapp.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Terrain {
    @PrimaryKey(autoGenerate = true)
    private int idTerrain;
    @ColumnInfo(name = "nom")
    private String nom;
    @ColumnInfo(name = "description")
    private String description;
    @ColumnInfo(name = "localisation")
    private String localisation;

    @ColumnInfo(name = "imageResourceId")
    private int imageResourceId;

    public Terrain(String nom, String description, String localisation, int imageResourceId) {
        this.nom = nom;
        this.description = description;
        this.localisation = localisation;
        this.imageResourceId = imageResourceId;
    }


    public Terrain() {
    }

    public int getIdTerrain() {
        return idTerrain;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public String getLocalisation() {
        return localisation;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        this.imageResourceId = imageResourceId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public void setIdTerrain(int idTerrain) {
        this.idTerrain = idTerrain;
    }

    @Override
    public String toString() {
        return "Terrain{" +
                "idTerrain=" + idTerrain +
                ", nom='" + nom + '\'' +
                ", description='" + description + '\'' +
                ", localisation='" + localisation + '\'' +
                ", imageResourceId=" + imageResourceId +
                '}';
    }
}
