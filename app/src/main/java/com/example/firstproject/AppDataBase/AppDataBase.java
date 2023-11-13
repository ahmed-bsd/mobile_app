package com.example.firstproject.AppDataBase;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.firstproject.DAO.AnnonceDAO;
import com.example.firstproject.Entities.Annonce;

//on va utiliser une seule annonce donc on va utilisé patron de conception singelton
@Database(entities = {Annonce.class}, version = 1, exportSchema = false)
public abstract class AppDataBase  extends RoomDatabase {

    //creer une varabiale du meme type de la classe  meme
    private static AppDataBase instance;
    //faire appel a la couche dao
    public abstract AnnonceDAO annonceDao();
    //créer une methode statique pour acceder a notre instance

    public static AppDataBase getInstance(Context context) {
        //si l'instance n'existe pas on va creer
        if (instance == null) {
         //créer la base de donnee avec le nom "marcheimmo_db"
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDataBase.class, "marcheimmo_db")
                    .allowMainThreadQueries()
                    .build();

        }
        return instance;
    }



}
