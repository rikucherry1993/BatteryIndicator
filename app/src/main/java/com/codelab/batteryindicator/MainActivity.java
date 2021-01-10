package com.codelab.batteryindicator;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private static final String CURRENT_LEVEL = "CURRENT_LEVEL";

    private ImageButton plusButton;
    private ImageButton minusButton;
    private ImageView batteryImage;
    private int currentLevel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        plusButton = findViewById(R.id.plus_button);
        minusButton = findViewById(R.id.minus_button);
        batteryImage = findViewById(R.id.battery_image);

        //todo: optimize logic
        currentLevel = 0;

        if (savedInstanceState != null) {
            currentLevel = savedInstanceState.getInt(CURRENT_LEVEL);
        }

    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(CURRENT_LEVEL,currentLevel);
        super.onSaveInstanceState(outState);
    }

    public void decrease(View view) {

        if (currentLevel > 0) {
            currentLevel--;
            batteryImage.setImageLevel(currentLevel);
        }
    }



    public void increase(View view){
        if (currentLevel < 7){
            currentLevel++;
            batteryImage.setImageLevel(currentLevel);
        }
    }


}