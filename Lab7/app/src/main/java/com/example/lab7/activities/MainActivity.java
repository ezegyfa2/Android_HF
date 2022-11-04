package com.example.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.lab7.R;
import com.example.lab7.adapters.AnimalAdapter;
import com.example.lab7.models.Animal;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Animal> animals;
    RecyclerView animalsView;
    AnimalAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        animalsView = (RecyclerView) findViewById(R.id.animalsView);
        animalsView.setHasFixedSize(true);

        final LinearLayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);

        animalsView.setLayoutManager(layoutManager);
        // get data
        animals = Animal.getAnimals();

        // Create an adapter
        adapter = new AnimalAdapter(MainActivity.this, animals);

        // Bind adapter to list
        animalsView.setAdapter(adapter);
    }
}