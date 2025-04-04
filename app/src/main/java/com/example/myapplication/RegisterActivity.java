package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.db.DatabaseHelper;

public class RegisterActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private EditText editTextUsername, editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        databaseHelper = new DatabaseHelper(this);

        editTextUsername = findViewById(R.id.loginButton);
        editTextPassword = findViewById(R.id.password);
        Button buttonRegister = findViewById(R.id.loginButton);

    }}