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

public class InvitationOnly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_invitation_only);


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Properly consume the insets
        });

        // Set up the ImageView for the white mug
        ImageView whiteImageView = findViewById(R.id.birthday);
        whiteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, BirthdayInvi.class);
            startActivity(intent);
        });

        // Set up the ImageView for the magic mug
        ImageView magicImageView = findViewById(R.id.creative);
        magicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, CreateInvi.class);
            startActivity(intent);
        });

        // Set up the ImageView for the frosted mug
        ImageView frostedImageView = findViewById(R.id.christening);
        frostedImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, CHInvi.class);
            startActivity(intent);
        });

        // Set up the ImageView for the Nordic mug
        ImageView nordicImageView = findViewById(R.id.texture);
        nordicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, TextInvi.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clearImageView = findViewById(R.id.pocket);
        clearImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, PocketInvi.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clear1ImageView = findViewById(R.id.wedding);
        clear1ImageView.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, WedInvi.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(InvitationOnly.this, EditProfile.class);
            startActivity(intent);
        });

    }
}