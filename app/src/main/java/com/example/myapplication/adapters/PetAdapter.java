package com.example.myapplication.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.models.Pet;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetViewHolder> {

    private Context context;
    private List<Pet> pets;

    public PetAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_pet, viewGroup, false);
        return new PetViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull PetViewHolder petViewHolder, int position) {

        petViewHolder.age.setText(Integer.toString(pets.get(position).getAge()));
        petViewHolder.race.setText(pets.get(position).getRace());
        petViewHolder.weight.setText(Double.toString(pets.get(position).getWeight()));

        petViewHolder.adopt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://www.dogstrust.ba/fostering";
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
        notifyDataSetChanged();
    }



}
