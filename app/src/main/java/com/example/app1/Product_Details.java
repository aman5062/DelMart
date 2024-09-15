package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Product_Details extends AppCompatActivity {
    ImageView product_image,share,back;
    Button bottom;
    RatingBar rating;
    TextView discription;

    int quantity_count=1;
    TextView product_price,product_name,quantity,quantity_plus,quantity_minus,total_price;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
        product_image = findViewById(R.id.product_image123);
        product_name = findViewById(R.id.product_name);
        product_price = findViewById(R.id.product_price);
        quantity = findViewById(R.id.quantity);
        discription = findViewById(R.id.discription);
        quantity_plus = findViewById(R.id.quantity_plus);
        quantity_minus = findViewById(R.id.quantity_minus);
        back = findViewById(R.id.back);
        total_price = findViewById(R.id.total_price);
        bottom = findViewById(R.id.bottom);
        rating = findViewById(R.id.rating);
        product_price.setText("(1 piece/₹"+getIntent().getStringExtra("price")+")");
        product_name.setText(getIntent().getStringExtra("Product_name"));
        rating.setRating(Integer.parseInt(getIntent().getStringExtra("rating")));


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Product_Details.super.onBackPressed();
            }
        });
       // int num = Integer.parseInt(getIntent().getStringExtra("Product_image"));

        share = findViewById(R.id.share);
        Log.e("TAG", "ImageValue: "+getIntent().getStringExtra("Product_image") );
       // Toast.makeText(this, ""+getIntent().getStringExtra("Product_image"), Toast.LENGTH_SHORT).show();
        Glide.with(getApplicationContext())
                .load(getIntent().getStringExtra("Product_image"))
                .centerCrop()
                .into(product_image);
        discription.setText(getIntent().getStringExtra("discription"));

        total_price.setText("₹"+(quantity_count *Integer.parseInt(getIntent().getStringExtra("price"))));
        quantity.setText(String.valueOf(quantity_count));
        quantity_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_count++;
                quantity.setText(String.valueOf(quantity_count));
                total_price.setText("₹"+String.valueOf(quantity_count*Integer.parseInt(getIntent().getStringExtra("price"))));
            }
        });
        quantity_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantity_count--;
                quantity.setText(String.valueOf(quantity_count));
                total_price.setText("₹"+String.valueOf(quantity_count*Integer.parseInt(getIntent().getStringExtra("price"))));
            }
        });
        bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Product_Details.this,Cart_Activity.class);
                intent.putExtra("image_link",getIntent().getStringExtra("Product_image"));
                intent.putExtra("name",getIntent().getStringExtra("Product_name"));
                intent.putExtra("quantity",String.valueOf(quantity_count));
                intent.putExtra("price",Integer.valueOf(getIntent().getStringExtra("price")));

                startActivity(intent);
            }
        });

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"Buy our Product!!!");
                intent.setType("text/plain");
                startActivity(intent);
            }
        });
    }
}