package com.example.lab6;

import android.os.Bundle;

import android.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CurrencyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CurrencyFragment extends Fragment {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.0000");
    private static final String IMAGE_ID = "imageId";
    private static final String SHORT_NAME = "shortName";
    private static final String LONG_NAME = "longName";
    private static final String BUY = "buy";
    private static final String SELL = "sell";

    private View lastSelectedListView = null;
    private Currency currency;

    public CurrencyFragment() {
        // Required empty public constructor
    }

    public static CurrencyFragment newInstance(int imageId, String shortName, String longName, double buy, double sell) {
        CurrencyFragment fragment = new CurrencyFragment();
        Bundle args = new Bundle();
        args.putInt(IMAGE_ID, imageId);
        args.putString(SHORT_NAME, shortName);
        args.putString(LONG_NAME, longName);
        args.putDouble(BUY, buy);
        args.putDouble(SELL, sell);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            currency = new Currency(
                getArguments().getInt(IMAGE_ID),
                getArguments().getString(SHORT_NAME),
                getArguments().getString(LONG_NAME),
                getArguments().getDouble(BUY),
                getArguments().getDouble(SELL)
            );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_currency, container, false);

        ImageView flagImageView = view.findViewById(R.id.flagImageView);
        TextView shortNameTextView = view.findViewById(R.id.shortNameTextView);
        TextView longNameTextView = view.findViewById(R.id.longTextView);
        TextView buyTextView = view.findViewById(R.id.buyTextView);
        TextView sellTextView = view.findViewById(R.id.sellTextView);

        flagImageView.setImageResource(currency.getImageId());
        shortNameTextView.setText(currency.getShortName());
        longNameTextView.setText(currency.getLongName());
        buyTextView.setText(decimalFormat.format(currency.getBuy()) + " RON");
        sellTextView.setText(decimalFormat.format(currency.getSell()) + " RON");

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeViewVisibility(view.findViewById(R.id.buyTitleTextView));
                changeViewVisibility(view.findViewById(R.id.buyTextView));
                changeViewVisibility(view.findViewById(R.id.sellTitleTextView));
                changeViewVisibility(view.findViewById(R.id.sellTextView));
            }
        });
        return view;
    }

    public static void changeViewVisibility(View view) {
        if (view.getVisibility() == View.VISIBLE) {
            view.setVisibility(View.INVISIBLE);
        }
        else {
            view.setVisibility(View.VISIBLE);
        }
    }
}