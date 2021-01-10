package com.codelab.batteryindicator;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_LEVEL = "CURRENT_LEVEL";

    private ImageButton plusButton;
    private ImageButton minusButton;
    private ImageView batteryImage;
    private TextView chargeLevelText;
    private int currentLevel;
    List<String> levelList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        batteryImage = findViewById(R.id.battery_image);
        chargeLevelText = findViewById(R.id.text_charge_level);

        levelList = Arrays.asList(getResources().getStringArray(R.array.charge_level));

        currentLevel = 0;
        chargeLevelText.setText(levelList.get(0));

        if (savedInstanceState != null) {
            currentLevel = savedInstanceState.getInt(CURRENT_LEVEL);
            chargeLevelText.setText(levelList.get(currentLevel));
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_LEVEL, currentLevel);
        super.onSaveInstanceState(outState);
    }

    public void decrease(View view) {

        if (currentLevel > 0) {
            currentLevel--;
            batteryImage.setImageLevel(currentLevel);
            chargeLevelText.setText(levelList.get(currentLevel));
        }
    }


    public void increase(View view) {
        if (currentLevel < 7) {
            currentLevel++;
            batteryImage.setImageLevel(currentLevel);
            chargeLevelText.setText(levelList.get(currentLevel));
        }
    }


}