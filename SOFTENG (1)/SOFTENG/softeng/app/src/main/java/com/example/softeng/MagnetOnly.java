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

public class MagnetOnly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_magnet_only);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Properly consume the insets
        });

        // Set up the ImageView for the white mug
        ImageView whiteImageView = findViewById(R.id.ACMag);
        whiteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MagnetOnly.this, AcryMag.class);
            startActivity(intent);
        });

        // Set up the ImageView for the magic mug
        ImageView magicImageView = findViewById(R.id.RefMag);
        magicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MagnetOnly.this, RefMag.class);
            startActivity(intent);
        });

        // Set up the ImageView for the frosted mug
        ImageView frostedImageView = findViewById(R.id.COMag);
        frostedImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MagnetOnly.this, CutOutMag.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MagnetOnly.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MagnetOnly.this, EditProfile.class);
            startActivity(intent);
        });
    }
}