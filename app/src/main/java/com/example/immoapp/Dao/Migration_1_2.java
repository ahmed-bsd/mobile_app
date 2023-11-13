package com.example.immoapp.Dao;

import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public class Migration_1_2 extends Migration {
    public Migration_1_2() {
        super(1, 2);
    }

    @Override
    public void migrate(SupportSQLiteDatabase database) {
        //jai changer la version lors de l'ajout de l'image donc limage seront remplacé par 0 par defaut s'ils nexistent pas
        database.execSQL("ALTER TABLE Terrain ADD COLUMN imageResourceId INTEGER NOT NULL DEFAULT 0");

    }
}
