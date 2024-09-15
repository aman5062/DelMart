package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.time.Instant;
import java.util.ArrayList;

public class Dashboard extends AppCompatActivity {

    private static final String USER_PREFS = "user";
    private static final String USERNAME_KEY = "Username";
    FrameLayout frame;
    LinearLayout home,notification,cart,profile;
    CardView searchme_bar;
    ImageView menu,image_home,image_category,image_cart,image_profile,profile_icon;
    Dialog dialog,dialog2,dialog3;
    TextView text_home,text_category,text_cart,text_profile,search_bar;
    SharedPreferences getSharedPreferences;





    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        getSupportActionBar().hide();
        getWindow().setStatusBarColor(Color.parseColor("#2196F3"));
        getWindow().setNavigationBarColor(Color.parseColor("#ffffff"));
        frame = findViewById(R.id.frame);
        home = findViewById(R.id.home);
        notification = findViewById(R.id.category);
        cart = findViewById(R.id.cart);
        profile = findViewById(R.id.profile);
        menu = findViewById(R.id.menu);

        image_cart = findViewById(R.id.image_cart);
        image_home = findViewById(R.id.image_home);
        image_category = findViewById(R.id.image_category);
        image_profile = findViewById(R.id.image_profile);
        text_cart = findViewById(R.id.text_cart);
        text_home = findViewById(R.id.text_home);
        text_category = findViewById(R.id.text_category);
        text_profile = findViewById(R.id.text_profile);
        search_bar = findViewById(R.id.search_bar);
        searchme_bar = findViewById(R.id.searchme_bar);
        profile_icon = findViewById(R.id.profile_icon);
        getSharedPreferences = getSharedPreferences(USER_PREFS, MODE_PRIVATE);
        String user = getSharedPreferences.getString(USERNAME_KEY, "none");

        String[] myArray = {"Toy", "Vegetables", "Fruits", "Electronics", "Fashion"};
        int delay = 3000; // 3 seconds delay

        Handler handler = new Handler();
        for (int i = 0; i < myArray.length; i++) {
            final int index = i;
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    search_bar.setHint(myArray[index]);
                    YoYo.with(Techniques.FadeInUp).duration(700).repeat(0).playOn(search_bar);
                }
            }, i * delay);
        }





        SetFragment("home");
        Glide.with(getApplicationContext()).load(R.drawable.home).centerCrop().into(image_home);
        text_home.setTextColor(Color.parseColor("#2196F3"));


        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                SetFragmentHome();
                SetFragment("home");

                YoYo.with(Techniques.Tada)
                        .duration(700)
                        .repeat(0)
                        .playOn(findViewById(R.id.image_home));
                text_category.setTextColor(Color.parseColor("#F2757171"));
                text_profile.setTextColor(Color.parseColor("#F2757171"));
                text_home.setTextColor(Color.parseColor("#2196F3"));
                text_cart.setTextColor(Color.parseColor("#F2757171"));

                Glide.with(getApplicationContext()).load(R.drawable.home).centerCrop().into(image_home);
                Glide.with(getApplicationContext()).load(R.drawable.category_change).centerCrop().into(image_category);
                Glide.with(getApplicationContext()).load(R.drawable.cart_change).centerCrop().into(image_cart);
                Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);
                searchme_bar.setVisibility(View.VISIBLE);
                profile_icon.setVisibility(View.VISIBLE);
            }
        });
        notification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment("notification");


                text_category.setTextColor(Color.parseColor("#2196F3"));
                text_profile.setTextColor(Color.parseColor("#F2757171"));
                text_home.setTextColor(Color.parseColor("#F2757171"));
                text_cart.setTextColor(Color.parseColor("#F2757171"));

                searchme_bar.setVisibility(View.VISIBLE);
                profile_icon.setVisibility(View.VISIBLE);
                Glide.with(getApplicationContext()).load(R.drawable.home_change).centerCrop().into(image_home);
                Glide.with(getApplicationContext()).load(R.drawable.category).centerCrop().into(image_category);
                Glide.with(getApplicationContext()).load(R.drawable.cart_change).centerCrop().into(image_cart);
                Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);

            }

        });
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment("cart");


                text_category.setTextColor(Color.parseColor("#F2757171"));
                text_profile.setTextColor(Color.parseColor("#F2757171"));
                text_home.setTextColor(Color.parseColor("#F2757171"));
                text_cart.setTextColor(Color.parseColor("#2196F3"));


                Glide.with(getApplicationContext()).load(R.drawable.home_change).centerCrop().into(image_home);
                Glide.with(getApplicationContext()).load(R.drawable.category_change).centerCrop().into(image_category);
                Glide.with(getApplicationContext()).load(R.drawable.cart).centerCrop().into(image_cart);
                Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);
                searchme_bar.setVisibility(View.INVISIBLE);
                profile_icon.setVisibility(View.INVISIBLE);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SetFragment("profile");



                text_category.setTextColor(Color.parseColor("#F2757171"));
                text_profile.setTextColor(Color.parseColor("#2196F3"));
                text_home.setTextColor(Color.parseColor("#F2757171"));
                text_cart.setTextColor(Color.parseColor("#F2757171"));


                Glide.with(getApplicationContext()).load(R.drawable.home_change).centerCrop().into(image_home);
                Glide.with(getApplicationContext()).load(R.drawable.category_change).centerCrop().into(image_category);
                Glide.with(getApplicationContext()).load(R.drawable.cart_change).centerCrop().into(image_cart);
                Glide.with(getApplicationContext()).load(R.drawable.person2).centerCrop().into(image_profile);

                searchme_bar.setVisibility(View.INVISIBLE);
                profile_icon.setVisibility(View.INVISIBLE);

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {


            TextView menu_home,menu_notification,menu_cart,menu_order,logout,menu_wishlist,menu_wallet,username_menu;
            LinearLayout close;
            ImageView closesymbol;
            @Override
            public void onClick(View v) {



                menu_home = dialog.findViewById(R.id.menu_home);
                logout = dialog.findViewById(R.id.logout);
                menu_notification = dialog.findViewById(R.id.menu_notification);
                menu_order = dialog.findViewById(R.id.menu_order);
                menu_wallet = dialog.findViewById(R.id.menu_Wallet);
                username_menu = dialog.findViewById(R.id.username_menu);

                menu_cart = dialog.findViewById(R.id.menu_cart);
                close = dialog.findViewById(R.id.close);
                closesymbol = dialog.findViewById(R.id.closesymbol);
                menu_wallet.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Dashboard.this,Activity_wallet.class);
                        startActivity(intent);
                    }
                });
                username_menu.setText(user);
                menu_order.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Dashboard.this,myorder_activity.class);
                        startActivity(intent);
                        dialog.dismiss();
                    }
                });

                menu_home.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        YoYo.with(Techniques.FadeIn)
                                .duration(100)
                                .repeat(0)
                                .playOn(menu_home);


                        SetFragment("home");
                        text_category.setTextColor(Color.parseColor("#F2757171"));
                        text_profile.setTextColor(Color.parseColor("#F2757171"));
                        text_home.setTextColor(Color.parseColor("#2196F3"));
                        text_cart.setTextColor(Color.parseColor("#F2757171"));

                        Glide.with(getApplicationContext()).load(R.drawable.home).centerCrop().into(image_home);
                        Glide.with(getApplicationContext()).load(R.drawable.category_change).centerCrop().into(image_category);
                        Glide.with(getApplicationContext()).load(R.drawable.cart_change).centerCrop().into(image_cart);
                        Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);
                        dialog.dismiss();

                    }
                });

                menu_cart.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        SetFragment("cart");
                        text_category.setTextColor(Color.parseColor("#F2757171"));
                        text_profile.setTextColor(Color.parseColor("#F2757171"));
                        text_home.setTextColor(Color.parseColor("#F2757171"));
                        text_cart.setTextColor(Color.parseColor("#2196F3"));

                        searchme_bar.setVisibility(View.INVISIBLE);
                        profile_icon.setVisibility(View.INVISIBLE);
                        Glide.with(getApplicationContext()).load(R.drawable.home_change).centerCrop().into(image_home);
                        Glide.with(getApplicationContext()).load(R.drawable.category_change).centerCrop().into(image_category);
                        Glide.with(getApplicationContext()).load(R.drawable.cart).centerCrop().into(image_cart);
                        Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);
                        dialog.dismiss();
                    }
                });

                close.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });
                closesymbol.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                logout.setOnClickListener(new View.OnClickListener() {

                    Button logout_yes,logout_no;
                    LinearLayout outside;
                    @Override
                    public void onClick(View v) {
                        dialog2 = new Dialog(Dashboard.this);
                        dialog2.setContentView(R.layout.logout_confirm_dialog);
                        dialog2.setCancelable(true);
                        dialog2.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                        dialog2.getWindow().getAttributes().windowAnimations = R.style.Theme_App1;
                        dialog2.getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_light_transparent);
                        dialog2.show();
                        logout_yes = dialog2.findViewById(R.id.logout_yes);
                        logout_no = dialog2.findViewById(R.id.logout_no);
                        logout_yes.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("User","none");
                                editor.apply();
                                Intent intent = new Intent(Dashboard.this,Login.class);
                                startActivity(intent);
                                dialog2.dismiss();
                                finish();
                            }
                        });
                        logout_no.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                dialog2.dismiss();
                            }
                        });
                    }
                });

            }
        });



    }



    public void SetFragment(String type){
        switch (type){
            case "home":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new HomeFragment())
                        .commit();

                break;
            case "notification":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new CategoryFragment())
                        .commit();
                text_category.setTextColor(Color.parseColor("#2196F3"));
                text_profile.setTextColor(Color.parseColor("#F2757171"));
                text_home.setTextColor(Color.parseColor("#F2757171"));
                text_cart.setTextColor(Color.parseColor("#F2757171"));

                searchme_bar.setVisibility(View.VISIBLE);
                profile_icon.setVisibility(View.VISIBLE);
                Glide.with(getApplicationContext()).load(R.drawable.home_change).centerCrop().into(image_home);
                Glide.with(getApplicationContext()).load(R.drawable.category).centerCrop().into(image_category);
                Glide.with(getApplicationContext()).load(R.drawable.cart_change).centerCrop().into(image_cart);
                Glide.with(getApplicationContext()).load(R.drawable.person_change).centerCrop().into(image_profile);
                break;
            case "cart":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new CartFragment())
                        .commit();
                break;
            case "profile":
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frame, new ProfileFragment())
                        .commit();
                break;

        }

    }

    @Override
    protected void onStart() {
        super.onStart();

    }
    Button exit_yes,exit_no;
    @Override
    public void onBackPressed() {

//        Toast.makeText(this, "Hello Back", Toast.LENGTH_SHORT).show();

        dialog3 = new Dialog(Dashboard.this);
        dialog3.setContentView(R.layout.exit_dialog);
        dialog3.setCancelable(true);
        dialog3.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        dialog3.getWindow().getAttributes().windowAnimations = R.style.Theme_App1;
        dialog3.getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_light_transparent);
        dialog3.show();
        exit_yes = dialog3.findViewById(R.id.exit_yes);
        exit_no = dialog3.findViewById(R.id.exit_no);
        exit_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dashboard.super.onBackPressed();
            }
        });
        exit_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog3.dismiss();
            }
        });
    }
}
