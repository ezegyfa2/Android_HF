package com.example.lab5;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class ColoredTextAdapter extends ArrayAdapter<ColoredText> {
    public ColoredTextAdapter(Context context, ArrayList<ColoredText> coloredTexts) {
        super(context, android.R.layout.simple_list_item_1, coloredTexts);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView textView = (TextView) super.getView(position, convertView, parent);
        textView.setTextColor(ContextCompat.getColor(getContext(), getItem(position).getColor()));
        return textView;
    }
}
