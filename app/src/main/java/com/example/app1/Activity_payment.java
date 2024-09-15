package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Activity_payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        getSupportActionBar().hide();
    }
}