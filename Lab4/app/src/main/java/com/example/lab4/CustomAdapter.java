package com.example.lab4;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.text.DecimalFormat;

public class CustomAdapter extends ArrayAdapter {
    private final Activity context;
    private static final DecimalFormat decimalFormat = new DecimalFormat("0.0000");
    private Currency[] currencies;

    public CustomAdapter(Activity context, Currency[] currencies){
        super(context, R.layout.currency, currencies);
        this.context = context;
        this.currencies = currencies;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.currency, null,true);

        ImageView flagImageView = rowView.findViewById(R.id.flagImageView);
        TextView shortNameTextView = rowView.findViewById(R.id.shortNameTextView);
        TextView longNameTextView = rowView.findViewById(R.id.longTextView);
        TextView buyTextView = rowView.findViewById(R.id.buyTextView);
        TextView sellTextView = rowView.findViewById(R.id.sellTextView);

        flagImageView.setImageResource(currencies[position].getImageId());
        shortNameTextView.setText(currencies[position].getShortName());
        longNameTextView.setText(currencies[position].getLongName());
        buyTextView.setText(decimalFormat.format(currencies[position].getBuy()) + " RON");
        sellTextView.setText(decimalFormat.format(currencies[position].getSell()) + " RON");

        return rowView;
    }
}
