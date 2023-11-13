package com.example.immoapp.AppDataBase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


import com.example.immoapp.Entities.Terrain;

import java.util.List;

@Dao
public interface DaoTerrain {

    @Insert
    void insert(Terrain terrain);

    @Query("SELECT * FROM Terrain")
    List<Terrain> getAll();

    @Query("SELECT * FROM Terrain WHERE idTerrain = :terrainId")
    Terrain getTerrainById(int terrainId);

    @Query("SELECT * FROM Terrain WHERE nom = :nomTerrain")
    List<Terrain> getTerrainsByName(String nomTerrain);
}
