package com.example.softeng;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class WhiteMug extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this); // Ensure this method is implemented correctly
        setContentView(R.layout.activity_clear_mug);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button buyButton = findViewById(R.id.buybtn);
        buyButton.setOnClickListener(v -> {
            Intent intent = new Intent(WhiteMug.this, BuynowWhiteMug.class);
            startActivity(intent);
        });
    }

    // Define EdgeToEdge.enable() method if it's a custom method
    public static class EdgeToEdge {
        public static void enable(AppCompatActivity activity) {
            // Implement the edge-to-edge enabling logic here
        }
    }
}
