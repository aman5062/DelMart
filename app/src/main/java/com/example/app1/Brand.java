package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Brand extends AppCompatActivity {

    TextView brand_name;
    ImageView brand_logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);
        getSupportActionBar().hide();
        brand_name = findViewById(R.id.brand_name);
        brand_logo = findViewById(R.id.brand_logo);
        String brand = getIntent().getStringExtra("Brand");
        brand_name.setText(getIntent().getStringExtra("Brand"));
        if(brand.equals("Boat")){

            Glide.with(Brand.this)
                    .load(R.drawable.boat)
                    .centerCrop()
                    .into(brand_logo);
        } else if (brand.equals("Canon")) {
            Glide.with(Brand.this)
                    .load(R.drawable.canon1)
                    .centerCrop()
                    .into(brand_logo);
        } else if (brand.equals("Puma")) {
            Glide.with(Brand.this)
                    .load(R.drawable.puma)
                    .centerCrop()
                    .into(brand_logo);
        }
    }
}