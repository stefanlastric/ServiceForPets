package com.example.myapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.myapplication.models.Pet;


@Database(
        entities = { Pet.class},
        version = 4,
        exportSchema = false
)
public abstract class MyDatabase extends RoomDatabase {

    private static MyDatabase INSTANCE = null;

    public abstract PetsDAO petsDAO();

    public static MyDatabase getDatabase(Context context) {
        if(INSTANCE == null) {
            INSTANCE = Room
                    .databaseBuilder(context, MyDatabase.class, "pets_database")
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return INSTANCE;
    }


}
