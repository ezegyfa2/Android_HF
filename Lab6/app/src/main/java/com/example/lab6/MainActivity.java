package com.example.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private Currency[] currencies = {
            new Currency(R.drawable.chf, "CHF", "Franc elvetian", 4.4100, 4.5500),
            new Currency(R.drawable.dkk, "DKK", "Coroana daneza", 3.9750, 4.1450),
            new Currency(R.drawable.eur, "EUR", "Euro", 6.1250, 6.3550),
            new Currency(R.drawable.gbp, "GBP", "Franc elvetian", 4.2300, 4.3300),
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        for (Currency currency: currencies) {
            fragmentTransaction.add(R.id.linearLayout, fragmentFromCurrency(currency));
        }
        fragmentTransaction.commit();
    }

    private CurrencyFragment fragmentFromCurrency(Currency currency) {
        return CurrencyFragment.newInstance(
                currency.getImageId(),
                currency.getShortName(),
                currency.getLongName(),
                currency.getBuy(),
                currency.getSell()
        );
    }
}