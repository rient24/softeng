package com.example.softeng;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class TumblerOnly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tumbler_only);


        // Applying window insets to the main layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Properly consume the insets
        });

        // Set up the ImageView for the white mug
        ImageView whiteImageView = findViewById(R.id.ColaJug);
        whiteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, ColaJug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the magic mug
        ImageView magicImageView = findViewById(R.id.SilicTum);
        magicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, SiliconTumb.class);
            startActivity(intent);
        });

        // Set up the ImageView for the frosted mug
        ImageView frostedImageView = findViewById(R.id.AquaTumb);
        frostedImageView.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, AquaTumb.class);
            startActivity(intent);
        });

        // Set up the ImageView for the Nordic mug
        ImageView nordicImageView = findViewById(R.id.GlassTumbl);
        nordicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, GlassTumb.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clearImageView = findViewById(R.id.Jug);
        clearImageView.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, JugTumb.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(TumblerOnly.this, EditProfile.class);
            startActivity(intent);
        });

    }
}
