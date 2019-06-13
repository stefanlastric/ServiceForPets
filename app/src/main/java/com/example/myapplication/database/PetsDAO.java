package com.example.myapplication.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.myapplication.models.Pet;

import java.util.List;

@Dao
public interface PetsDAO {

    @Insert
    public void addPet(Pet pet);

    @Query("DELETE FROM pets")
    public void deleteAll();

    @Query("SELECT * FROM pets")
    public List<Pet> getAllPets();

    @Query("SELECT * FROM pets WHERE id=:id")
    public Pet getPetById(int id);

    @Query("SELECT COUNT(*) FROM pets")
    public int getCount();

}
