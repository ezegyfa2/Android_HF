package com.example.activitystatesavetwo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;

import org.jetbrains.annotations.NotNull;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        checkBox = findViewById(R.id.checkBox);
    }

    @Override
    protected void onRestoreInstanceState(@NotNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        editText.setText(savedInstanceState.getString("editText"));
        checkBox.setChecked(savedInstanceState.getBoolean("checkBox"));
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putString("editText", editText.getText().toString());
        savedInstanceState.putBoolean("checkBox", checkBox.isChecked());
    }
}