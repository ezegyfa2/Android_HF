package com.example.lab7.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab7.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        TextView nameTextView = (TextView)findViewById(R.id.nameTextView);
        nameTextView.setText(getIntent().getStringExtra("name"));
        ImageView animalImageView = (ImageView)findViewById(R.id.animalImageView);
        animalImageView.setImageResource(getIntent().getIntExtra("image", 0));
        TextView descriptionTextView = (TextView)findViewById(R.id.descriptionTextView);
        descriptionTextView.setText(getIntent().getStringExtra("description"));
    }
}