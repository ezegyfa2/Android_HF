package com.example.lab7.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab7.R;
import com.example.lab7.activities.DetailsActivity;
import com.example.lab7.activities.MainActivity;
import com.example.lab7.models.Animal;

import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.AnimalViewHolder> {
    //to reference the Activity
    private final Activity context;

    private List<Animal> animals;

    public AnimalAdapter(Activity context, List<Animal> animalsParam){
        this.context = context;
        if (animalsParam == null) {
            throw new IllegalArgumentException("animals must not be null");
        }
        this.animals = animalsParam;
    }

    // Inflate the view based on the viewType provided.
    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.animal_list_item, parent, false);
        return new AnimalViewHolder(itemView);
    }

    // Display data at the specified position
    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        Animal animal = animals.get(position);

        holder.nameView.setText(animal.getName());
        holder.imageView.setImageResource(animal.getImageId());
        holder.imageView.setTag(animal.getImageId());
        holder.descriptionView.setText(animal.getDescription());
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class AnimalViewHolder extends RecyclerView.ViewHolder {
        TextView nameView;
        ImageView imageView;
        TextView descriptionView;

        public AnimalViewHolder(View view) {
            super(view);

            nameView = view.findViewById(R.id.listNameTextView);
            imageView = view.findViewById(R.id.listAnimalImageView);
            descriptionView = view.findViewById(R.id.listDescriptionTextView);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name", nameView.getText().toString());
                    intent.putExtra("image", (int)imageView.getTag());
                    intent.putExtra("description", descriptionView.getText().toString());
                    context.startActivity(intent);
                }
            });
        }
    }
}
