package com.sanskar.a1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Intent action strings - A2 will listen for these
    public static final String ATTRACTIONS_INTENT =
            "com.sanskar.a1.SHOW_ATTRACTIONS";
    public static final String RESTAURANTS_INTENT =
            "com.sanskar.a1.SHOW_RESTAURANTS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAttractions = findViewById(R.id.buttonAttractions);
        Button btnRestaurants = findViewById(R.id.buttonRestaurants);

        btnAttractions.setOnClickListener(view -> {
            Toast.makeText(this, "Loading Chicago Attractions...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(ATTRACTIONS_INTENT);
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);
        });

        btnRestaurants.setOnClickListener(view -> {
            Toast.makeText(this, "Loading Chicago Restaurants...", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(RESTAURANTS_INTENT);
            intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            sendBroadcast(intent);
        });
    }
}