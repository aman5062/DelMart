package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.app1.adapter.Product_Adapter;


import java.util.ArrayList;

public class Productpage extends AppCompatActivity {
    TextView product_name;
    RecyclerView recycler;
    Product_Adapter product;
    ImageView back;
    Context context;
    String s;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
        setContentView(R.layout.activity_productpage);
        product_name = findViewById(R.id.product_name);
        recycler = findViewById(R.id.recycler);
        back = findViewById(R.id.back);
        product_name.setText(getIntent().getStringExtra("Product"));
        s = getIntent().getStringExtra("Product");
        productlist();

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Productpage.super.onBackPressed();
            }
        });
    }

    public void productlist(){

        switch (s) {
            case "Refine Oil":
                ArrayList<String> Name = new ArrayList<>();
                Name.add("Saffola : 100% Vegetable Oil");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                ArrayList<Integer> Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                ArrayList<String> Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;

            case "Snacks":
                Name = new ArrayList<>();
                Name.add("Biscuit");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Tea":
                Name = new ArrayList<>();
                Name.add("Lipton");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Rice":
                Name = new ArrayList<>();
                Name.add("Baba");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Vegetables":
                Name = new ArrayList<>();
                Name.add("Cucumber");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Pulses":
                Name = new ArrayList<>();
                Name.add("Moong");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Washing Machine":
                Name = new ArrayList<>();
                Name.add("LG");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Mobile":
                Name = new ArrayList<>();
                Name.add("Oppo");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Television":
                Name = new ArrayList<>();
                Name.add("Samsung");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Watches":
                Name = new ArrayList<>();
                Name.add("Roylex");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Games":
                Name = new ArrayList<>();
                Name.add("LG");
                Name.add("Samsung");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;
            case "Headphones":
                Name = new ArrayList<>();
                Name.add("Boat");
                Name.add("Patanjali");
                Name.add("Sunrise");
                Name.add("Fortune");

                Image = new ArrayList<Integer>();
                Image.add(R.drawable.safola);
                Image.add(R.drawable.patanjali);
                Image.add(R.drawable.sunrise);
                Image.add(R.drawable.fortune);

                Price = new ArrayList<>();
                Price.add("500");
                Price.add("1500");
                Price.add("2500");
                Price.add("5500");

                try {
                    recycler.setLayoutManager(new GridLayoutManager(context, 3));
                    recycler.setHasFixedSize(true);
                    product = new Product_Adapter(getBaseContext(), Name, Image, Price);
                    recycler.setAdapter(product);
                } catch (Exception e) {
                    Log.e("TAG", "Callcategory: " + e);
                }
                break;

        }


    }}