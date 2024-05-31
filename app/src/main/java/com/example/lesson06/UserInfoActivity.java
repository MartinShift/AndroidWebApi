package com.example.lesson06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserInfoActivity extends AppCompatActivity {
    private TextView tvName, tvUsername, tvEmail, tvPhone, tvWebsite, tvLastName, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        tvName = findViewById(R.id.tvName);
        tvLastName = findViewById(R.id.tvLastName);
        tvUsername = findViewById(R.id.tvUsername);
        tvEmail = findViewById(R.id.tvEmail);
        tvPhone = findViewById(R.id.tvPhone);
        tvWebsite = findViewById(R.id.tvWebsite);
        btnBack = findViewById(R.id.btnBack);

        Intent intent = getIntent();
        User user = (User) intent.getSerializableExtra("USER");

        if (user != null) {
            tvName.setText(user.getName());
            tvLastName.setText(user.getLastName());
            tvUsername.setText(user.getUsername());
            tvEmail.setText(user.getEmail());
            tvPhone.setText(user.getPhone());
            tvWebsite.setText(user.getWebsite());
        }

        btnBack.setOnClickListener(v -> finish());
    }
}