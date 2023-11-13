package com.example.firstproject.DAO;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.firstproject.Entities.Annonce;

import java.util.List;

@Dao
public interface AnnonceDAO {

    @Insert
    void insertAnnonce(Annonce annonce);
    @Delete
    void deleteAnnonce(Annonce annonce);
    @Query("SELECT * FROM Annonce_table")
    List<Annonce> getAllAnnonce();

    @Query("SELECT * FROM Annonce_table WHERE idAnnonce = :id")
    Annonce getAnnonceById(int id);


}
