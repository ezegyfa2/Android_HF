package com.example.lab32;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    LinkedList<Product> termekek = new LinkedList<>();
    Product aktualisTermek = new Product();
    EditText productCodeEditText;
    EditText productNameEditText;
    EditText productPriceEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        productCodeEditText = findViewById(R.id.productCodeEditText);
        productNameEditText = findViewById(R.id.productNameEditText);
        productPriceEditText = findViewById(R.id.productPriceEditText);

        final Button addProductButton = findViewById(R.id.addProductButton);
        addProductButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                beallitAktualisTermek();
                termekek.add(aktualisTermek);
            }
        });

        final TextView productsTextView = findViewById(R.id.productsTextView);
        final Button showProductsButton = findViewById(R.id.showProductsButton);
        showProductsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                productsTextView.setText("\n");
                for (Product termek : termekek) {
                    productsTextView.setText(productsTextView.getText().toString() + termek + "\n");
                }
            }
        });
    }

    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        productCodeEditText.setText(savedInstanceState.getString("productCode"));
        productNameEditText.setText(savedInstanceState.getString("productName"));
        productPriceEditText.setText(savedInstanceState.getString("productPrice"));
        beallitAktualisTermek();
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        beallitAktualisTermek();
        savedInstanceState.putString("productCode", aktualisTermek.code);
        savedInstanceState.putString("productName", aktualisTermek.name);
        savedInstanceState.putString("productPrice", aktualisTermek.price);
    }

    protected void beallitAktualisTermek() {
        String productCode = productCodeEditText.getText().toString();
        String productName = productNameEditText.getText().toString();
        String productPrice = productPriceEditText.getText().toString();
        aktualisTermek = new Product(productCode, productName, productPrice);
    }
}