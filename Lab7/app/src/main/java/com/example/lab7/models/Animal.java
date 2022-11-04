package com.example.lab7.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab7.R;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Animal {
    private String name;
    private int imageId;
    private String description;

    public Animal(String name, int imageId, String description) {
        this.name = name;
        this.imageId = imageId;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getImageId() {
        return imageId;
    }

    public String getDescription() {
        return description;
    }

    public static List<Animal> getAnimals() {
        return Arrays.asList(new Animal[] {
                new Animal("Octopus", R.drawable.octopus3, "8 tentacled monster"),
                new Animal("Pig", R.drawable.disznyo, "Delicious in rolls"),
                new Animal("Sheep", R.drawable.sheep, "Nice in a stew"),
                new Animal("Rabbit", R.drawable.rabbit, "Great for jumpers"),
                new Animal("Giraffe", R.drawable.giraffe, "Has a long neck"),
                new Animal("Horse", R.drawable.octopus3, "It's a horse"),
                new Animal("Lion", R.drawable.lion, "It's a lion")
        });
    }
}
