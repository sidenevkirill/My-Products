package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.db.UserDatabaseHelper;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {
    private TextInputEditText usernameEditText;
    private TextInputEditText passwordEditText;
    private UserDatabaseHelper userDatabaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
        TextView registerButton = findViewById(R.id.registerButton);
        Button loginButton = findViewById(R.id.loginButton);

        userDatabaseHelper = new UserDatabaseHelper(this);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (userDatabaseHelper.registerUser(username, password)) {
                    Toast.makeText(LoginActivity.this, "Регистрация успешна", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Ошибка регистрации", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = usernameEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if (userDatabaseHelper.loginUser(username, password)) {
                    Toast.makeText(LoginActivity.this, "Авторизация успешна", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(LoginActivity.this, MainAcivity.class);
                    startActivity(intent);


                }
            }
        });
    }
}