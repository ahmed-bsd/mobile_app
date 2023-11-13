package com.example.immoapp.Dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.immoapp.AppDataBase.DaoTerrain;
import com.example.immoapp.Entities.Terrain;

@Database(entities = {Terrain.class}, version =2 ,exportSchema = false)
public abstract class AppDataBase extends RoomDatabase {
    private  static AppDataBase instance;
    public abstract DaoTerrain daoTerrain();
    public static AppDataBase getInstance(Context ctx){
        if(instance == null){
            instance = Room.databaseBuilder(ctx.getApplicationContext(),AppDataBase.class,"local")
                    .allowMainThreadQueries()
                    .addMigrations(new Migration_1_2())
                    .build();
        }
        return instance;
    }

}
