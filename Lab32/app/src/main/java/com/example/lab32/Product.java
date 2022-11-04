package com.example.lab32;

import androidx.annotation.NonNull;

public class Product {
    public String code;
    public String name;
    public String price;

    public Product() {
        this("", "", "");
    }

    public Product(String _code, String _name, String _price) {
        code = _code;
        name = _name;
        price = _price;
    }

    @NonNull
    public String toString() {
        return code + " " + name + " " + price;
    }
}
