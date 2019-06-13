package com.example.myapplication.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.database.MyDatabase;
import com.example.myapplication.database.PetsDAO;
import com.example.myapplication.R;
import com.example.myapplication.models.Pet;

public class AdminActivity extends AppCompatActivity {

    EditText race;
    EditText age;
    EditText weight;

    Button addButton;
    Button deleteAllButton;

    TextView numberOfPets;

    PetsDAO database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        database = MyDatabase.getDatabase(this).petsDAO();

        numberOfPets = findViewById(R.id.numberOfPets);

        race = findViewById(R.id.edit_race);
        age = findViewById(R.id.edit_age);
        weight = findViewById(R.id.edit_weight);

        addButton = findViewById(R.id.button_add);
        deleteAllButton = findViewById(R.id.button_delete_all);


        showNumber();



        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pet pet = new Pet(race.getText().toString(), Integer.parseInt(age.getText().toString()), Integer.parseInt(weight.getText().toString()));
                database.addPet(pet);
                showNumber();
            }
        });

        deleteAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                database.deleteAll();
                showNumber();
            }
        });

    }

    public void showNumber() {
        int numberOfPetsInt = database.getCount();
        if(numberOfPets != null) {
            numberOfPets.setText(Integer.toString(numberOfPetsInt));
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id==android.R.id.home)
        {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
