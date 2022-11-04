package com.example.lab5;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    ColoredText[] listItems = new ColoredText[]{
            new ColoredText("Elem 2", R.color.green),
            new ColoredText("Elem 1", R.color.green),
            new ColoredText("Elem 3", R.color.green),
            new ColoredText("Elem 4", R.color.green)
    };
    ArrayList<ColoredText> list = new ArrayList<ColoredText>(Arrays.asList(listItems));
    ColoredTextAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        adapter = new ColoredTextAdapter(this, list);
        registerForContextMenu(listView);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sortOptionItem:
                list.sort(new Comparator<ColoredText>() {
                    @Override
                    public int compare(ColoredText ct1, ColoredText ct2) {
                        return ct1.getText().compareTo(ct2.getText());
                    }
                });
                adapter.notifyDataSetChanged();
                return true;
            case R.id.deleteOptionItem:
                list.removeAll(list);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.redContextItem:
                list.get(info.position).setColor(R.color.red);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.greenContextItem:
                list.get(info.position).setColor(R.color.green);
                adapter.notifyDataSetChanged();
                return true;
            case R.id.yellowContextItem:
                list.get(info.position).setColor(R.color.yellow);
                adapter.notifyDataSetChanged();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
}