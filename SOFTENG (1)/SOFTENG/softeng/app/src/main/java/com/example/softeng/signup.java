package com.example.softeng;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class signup extends AppCompatActivity {

    private EditText signinUserEditText;
    private EditText signupEmailEditText;
    private EditText signupPassEditText;
    private EditText signupConfPassEditText;

    private FirebaseFirestore db; // Declaring db as class variable
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);

        db = FirebaseFirestore.getInstance(); // Initializing db
        mAuth = FirebaseAuth.getInstance(); // Initializing FirebaseAuth

        signinUserEditText = findViewById(R.id.signinUser);
        signupEmailEditText = findViewById(R.id.signupEmail);
        signupPassEditText = findViewById(R.id.signupPass);
        signupConfPassEditText = findViewById(R.id.signupConfPass);

        TextView LOGIN = findViewById(R.id.LOGIN);
        LOGIN.setPaintFlags(LOGIN.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        LOGIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform the transition to the next page (activity)
                Intent intent = new Intent(signup.this, MainActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.signupbtn).setOnClickListener(v -> signUp());

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void signUp() {
        String fullName = signinUserEditText.getText().toString().trim();
        String email = signupEmailEditText.getText().toString().trim();
        String password = signupPassEditText.getText().toString().trim();
        String retypePassword = signupConfPassEditText.getText().toString().trim();

        if (TextUtils.isEmpty(fullName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(retypePassword)) {
            Toast.makeText(signup.this, "Sign up failed. Please fill in all fields.", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!password.equals(retypePassword)) {
            Toast.makeText(signup.this, "Password doesn't match.", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create user with email and password
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, task -> {
                    if (task.isSuccessful()) {
                        FirebaseUser user = mAuth.getCurrentUser();
                        if (user != null) {
                            // If user creation is successful, add user data to Firestore
                            Map<String, Object> userData = new HashMap<>();
                            userData.put("fullName", fullName);
                            userData.put("email", email);
                            userData.put("password", password);


                            // Add user data to Firestore
                            db.collection("users").document(user.getUid())
                                    .set(userData)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(signup.this, "Sign up Successful", Toast.LENGTH_SHORT).show();
                                        // Redirect to HomePage.java
                                        Intent intent = new Intent(signup.this, MainActivity.class);
                                        startActivity(intent);
                                        finish(); // Optional: finish current activity to prevent going back to SignUp page
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(signup.this, "Sign up Failed" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    });
                        }
                    } else {
                        Toast.makeText(signup.this, "Sign up Failed" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }
}
