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

public class OthersOnly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_others_only);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Properly consume the insets
        });

        // Set up the ImageView for the white mug
        ImageView whiteImageView = findViewById(R.id.mouse);
        whiteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersMouse.class);
            startActivity(intent);
        });

        // Set up the ImageView for the magic mug
        ImageView magicImageView = findViewById(R.id.coast);
        magicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersCoaster.class);
            startActivity(intent);
        });

        // Set up the ImageView for the frosted mug
        ImageView frostedImageView = findViewById(R.id.shirt);
        frostedImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersShirt.class);
            startActivity(intent);
        });

        // Set up the ImageView for the Nordic mug
        ImageView nordicImageView = findViewById(R.id.can);
        nordicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersCan.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clearImageView = findViewById(R.id.loot);
        clearImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersLoot.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clear1ImageView = findViewById(R.id.business);
        clear1ImageView.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, OthersBusiness.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(OthersOnly.this, EditProfile.class);
            startActivity(intent);
        });
    }
}