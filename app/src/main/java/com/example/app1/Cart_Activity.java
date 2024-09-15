package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class Cart_Activity extends AppCompatActivity implements LocationUtils.LocationListener{
    ImageView cart_image,location_icon;
    Button payment;
    TextView  cart_name;
    EditText pincode,state, Locality,road;
    Dialog dialog,dialog2;

    RadioGroup radiogrp;
    RadioButton upi,cash;
    private static final int PERMISSION_REQUEST_CODE = 1;
    private LocationUtils locationUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        getSupportActionBar().hide();

        cart_image = findViewById(R.id.cart_image);
        cart_name= findViewById(R.id.cart_name);
        location_icon = findViewById(R.id.location_icon);
        pincode = findViewById(R.id.pincode);
        state = findViewById(R.id.state);
        Locality = findViewById(R.id.Locality);
        road = findViewById(R.id.road);


        radiogrp = findViewById(R.id.radiogrp);
        upi = findViewById(R.id.upi);
        cash = findViewById(R.id.cash);

        radiogrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.upi:
                       payment.setText("Payment");
                        break;
                    case R.id.cash:
                        payment.setText("Confirm");
                        break;
                    // Add more cases for additional radio buttons if needed
                }
            }
        });


        payment = findViewById(R.id.payment);
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(payment.getText().equals("Payment")){
                    Intent intent = new Intent(Cart_Activity.this,Activity_payment.class);
                    startActivity(intent);

                } else if (payment.getText().equals("Confirm")) {

                    dialog = new Dialog(Cart_Activity.this);
                    dialog.setContentView(R.layout.order_confirm_dialog);
                    dialog.setCancelable(true);
                    dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                    dialog.getWindow().getAttributes().windowAnimations = R.style.Theme_App1;
                    dialog.getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_light_transparent);
                    dialog.show();

                    Button confirm_yes = dialog.findViewById(R.id.confirm_yes);
                    Button confirm_no = dialog.findViewById(R.id.confirm_no);
                    confirm_yes.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                            dialog2 = new Dialog(Cart_Activity.this);
                            dialog2.setContentView(R.layout.order_placed_dialog);
                            dialog2.setCancelable(true);
                            dialog2.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                            dialog2.getWindow().getAttributes().windowAnimations = R.style.Theme_App1;
                            dialog2.getWindow().setBackgroundDrawableResource(android.R.drawable.screen_background_light_transparent);
                            dialog2.show();

                            ImageView gifimage = dialog2.findViewById(R.id.gifimage);
                            Glide
                                    .with(Cart_Activity.this)
                                    .load(R.drawable.ordered)
                                    .centerCrop()
                                    .into(gifimage);

                            LinearLayout whole = dialog2.findViewById(R.id.whole);
                            whole.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {

                                    Intent intent = new Intent(Cart_Activity.this,myorder_activity.class);
                                    startActivity(intent);
                                    dialog2.dismiss();

                                }
                            });
                        }
                    });
                    confirm_no.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialog.dismiss();
                        }
                    });
                }
            }
        });

        cart_name.setText(getIntent().getStringExtra("name"));

        locationUtils = new LocationUtils(this);

        Glide.with(Cart_Activity.this)
                .load(getIntent().getStringExtra("image_link"))
                .centerCrop()
                .into(cart_image);

        location_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLocationPermission();
            }
        });
    }
    private void requestLocationPermission(){
        if (checkSelfPermission(android.Manifest.permission.ACCESS_FINE_LOCATION)== PackageManager.PERMISSION_GRANTED){
            startLocationUpdates();
        }else{
            requestPermissions(new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION},PERMISSION_REQUEST_CODE);
        }
    }

    private void startLocationUpdates()
    {
        locationUtils.requestLocationUpdates(this);

    }


    public void onRequestPermissionResult(int requestCode, String[] permission, int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permission, grantResults);
        if(requestCode == PERMISSION_REQUEST_CODE){
            if (grantResults.length>0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                startLocationUpdates();
            }else {
                Toast.makeText(this, "Location permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onLocationRecieved(Location location) {

    }

    @Override
    public void onLocationError(String errorMessage) {
        Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onAddressRecieved(String city, String postalCode, String locality,String Road) {
    pincode.setText(postalCode);
    state.setText(city);
    Locality.setText(locality);
    road.setText(Road);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
    @Override
    protected void onStop(){
        super.onStop();
        locationUtils.stopLocationUpdates();
    }


}
