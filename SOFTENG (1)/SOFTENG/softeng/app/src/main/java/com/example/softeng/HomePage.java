package com.example.softeng;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomePage extends AppCompatActivity {

    private FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home_page);

        // Apply window insets as padding for the 'main' view.
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets.consumeSystemWindowInsets();
        });

        setupClickListeners();
    }

    private void setupClickListeners() {
        ImageView mug1ImageView = findViewById(R.id.mug1);
        mug1ImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, MugsOnly.class);
            startActivity(intent);
        });

        ImageView tumblerImageView = findViewById(R.id.tumbler);
        tumblerImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, TumblerOnly.class);
            startActivity(intent);
        });

        ImageView clockImageView = findViewById(R.id.clock);
        clockImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, ClockOnly.class);
            startActivity(intent);
        });

        ImageView invitationImageView = findViewById(R.id.invi);
        invitationImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, InvitationOnly.class);
            startActivity(intent);
        });

        ImageView magnetImageView = findViewById(R.id.magnet);
        magnetImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, MagnetOnly.class);
            startActivity(intent);
        });

        ImageView coasterImageView = findViewById(R.id.coaster);
        coasterImageView.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, OthersOnly.class);
            startActivity(intent);
        });

        ImageButton messageImageButton = findViewById(R.id.message);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, ChatActivity.class);
            startActivity(intent);
        });

        ImageButton profileImageButton = findViewById(R.id.profile);
        profileImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(HomePage.this, EditProfile.class);
            startActivity(intent);
        });
    }
}