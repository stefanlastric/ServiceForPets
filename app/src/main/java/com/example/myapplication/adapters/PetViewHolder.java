package com.example.myapplication.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.R;

public class PetViewHolder extends RecyclerView.ViewHolder {

    TextView race;
    TextView age;
    TextView weight;
    Button adopt;


    public PetViewHolder(@NonNull View itemView) {
        super(itemView);

        race = itemView.findViewById(R.id.race);
        age = itemView.findViewById(R.id.age);
        weight = itemView.findViewById(R.id.weight);
        adopt = itemView.findViewById(R.id.adopt_button);
    }
}
