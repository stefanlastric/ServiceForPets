package com.example.myapplication.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "pets")
public class Pet {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String race;
    private int age;
    private double weight;

    public Pet(int id, String race, int age, double weight) {
        this.id = id;
        this.race = race;
        this.age = age;
        this.weight = weight;
    }

    @Ignore
    public Pet(String race, int age, double weight) {
        this.race = race;
        this.age = age;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getRace() {
        return race;
    }

    public int getAge() {
        return age;
    }

    public double getWeight() {
        return weight;
    }


}
