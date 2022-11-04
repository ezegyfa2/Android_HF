package com.lab1;

import static java.lang.Math.round;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.number.Precision;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button pluszButton = findViewById(R.id.pluszButton);
        pluszButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    eredmenyAtiras(szam1() + szam2());
                }
                catch (Exception e) {
                    hiba(e);
                }
            }
        });

        final Button minuszButton = findViewById(R.id.minuszButton);
        minuszButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    eredmenyAtiras(szam1() - szam2());
                }
                catch (Exception e) {
                    hiba(e);
                }
            }
        });

        final Button szorButton = findViewById(R.id.szorButton);
        szorButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    eredmenyAtiras(szam1() * szam2());
                }
                catch (Exception e) {
                    hiba(e);
                }
            }
        });

        final Button osztButton = findViewById(R.id.osztButton);
        osztButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                try {
                    eredmenyAtiras(szam1() / szam2());
                }
                catch (Exception e) {
                    hiba(e);
                }
            }
        });
    }

    protected double szam1() {
        final EditText szamEditText1 = findViewById(R.id.szam1TextNumber);
        return Double.parseDouble(szamEditText1.getText().toString());
    }

    protected double szam2() {
        final EditText szamEditText2 = findViewById(R.id.szam2TextNumber);
        return Double.parseDouble(szamEditText2.getText().toString());
    }

    protected void eredmenyAtiras(double ujEredmeny) {
        final TextView eredmenyTextView = findViewById(R.id.eredmenyTextView);
        eredmenyTextView.setText(String.format("Eredmeny: %.2f", ujEredmeny));
    }

    protected void hiba(Exception e) {
        final TextView eredmenyTextView = findViewById(R.id.eredmenyTextView);
        eredmenyTextView.setText("Hiba: " + e.getMessage());
    }
}