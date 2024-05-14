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

public class MugsOnly extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_mugs_only);

        // Applying window insets to the main layout
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return WindowInsetsCompat.CONSUMED; // Properly consume the insets
        });

        // Set up the ImageView for the white mug
        ImageView whiteImageView = findViewById(R.id.whitemug2);
        whiteImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, WhiteMug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the magic mug
        ImageView magicImageView = findViewById(R.id.magicmug);
        magicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, MagicMug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the frosted mug
        ImageView frostedImageView = findViewById(R.id.frostedmug);
        frostedImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, FrostedMug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the Nordic mug
        ImageView nordicImageView = findViewById(R.id.Nordic);
        nordicImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, NordicMug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the clear mug
        ImageView clearImageView = findViewById(R.id.Clear);
        clearImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, ClearMug.class);
            startActivity(intent);
        });

        // Set up the ImageView for the inner mug
        ImageView innerImageView = findViewById(R.id.Inner);
        innerImageView.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, InnerMug.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MugsOnly.this, EditProfile.class);
            startActivity(intent);
        });
    }
}
