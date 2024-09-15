package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_wallet extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);
        getSupportActionBar().hide();
    }
}