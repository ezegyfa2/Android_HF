package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    Currency[] currencies = {
            new Currency(R.drawable.chf, "CHF", "Franc elvetian", 4.4100, 4.5500),
            new Currency(R.drawable.dkk, "DKK", "Coroana daneza", 3.9750, 4.1450),
            new Currency(R.drawable.eur, "EUR", "Euro", 6.1250, 6.3550),
            new Currency(R.drawable.gbp, "GBP", "Franc elvetian", 4.2300, 4.3300),
    };
    View lastSelectedListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomAdapter myAdapter = new CustomAdapter(this, currencies);
        ListView currencyListView = findViewById(R.id.currencyListView);
        currencyListView.setAdapter(myAdapter);

        currencyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                view.findViewById(R.id.buyTitleTextView).setVisibility(View.VISIBLE);
                view.findViewById(R.id.buyTextView).setVisibility(View.VISIBLE);
                view.findViewById(R.id.sellTitleTextView).setVisibility(View.VISIBLE);
                view.findViewById(R.id.sellTextView).setVisibility(View.VISIBLE);
                if (lastSelectedListView != null) {
                    lastSelectedListView.findViewById(R.id.buyTitleTextView).setVisibility(View.INVISIBLE);
                    lastSelectedListView.findViewById(R.id.buyTextView).setVisibility(View.INVISIBLE);
                    lastSelectedListView.findViewById(R.id.sellTitleTextView).setVisibility(View.INVISIBLE);
                    lastSelectedListView.findViewById(R.id.sellTextView).setVisibility(View.INVISIBLE);
                }
                lastSelectedListView = view;
            }
        });
    }
}