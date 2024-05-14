package com.example.softeng;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button; // Import statement for Button
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MagicMug extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_magic_mug);

        // Set window insets listener
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets.consumeSystemWindowInsets(); // Properly consume insets
        });

        // Set click listener for message image button
        ImageButton messageImageButton = findViewById(R.id.cart);
        messageImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MagicMug.this, Cart.class);
            startActivity(intent);
        });

        // Set click listener for cart button
        Button cartImageButton = findViewById(R.id.buybtn);
        cartImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(MagicMug.this, QR.class);
            startActivity(intent);
        });
    }
}
