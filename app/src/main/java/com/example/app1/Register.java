package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app1.Model.SignupResponseModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Register extends AppCompatActivity {
        TextView login;
        Button Registerbtn;
        ProgressBar progress_register;
        EditText password,username;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getWindow().setStatusBarColor(Color.parseColor("#F0F2F5"));
        getSupportActionBar().hide();
        login = findViewById(R.id.login);
        password = findViewById(R.id.password);
        username = findViewById(R.id.username);
        Registerbtn = findViewById(R.id.loginbtn);
        progress_register = findViewById(R.id.progress_register);
        progress_register.setVisibility(View.GONE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this,Login.class);
                startActivity(intent);
            }
        });
        Registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progress_register.setVisibility(View.VISIBLE);
                Registerbtn.setEnabled(false);

                ServiceApi serviceApi = ApiClient.getUser().create(ServiceApi.class);
                Call<SignupResponseModel> call = serviceApi.getSignup(username.getText().toString().trim(),password.getText().toString().trim());


                call.enqueue(new Callback<SignupResponseModel>() {
                    @Override
                    public void onResponse(Call<SignupResponseModel> call, Response<SignupResponseModel> response) {

                        if (response.body() != null)
                        {
                            if(response.body().getCreated() == 1)
                            {
                                Toast.makeText(Register.this, "Successfully Registered!", Toast.LENGTH_SHORT).show();
                                progress_register.setVisibility(View.GONE);
                                Registerbtn.setEnabled(true);
                                Intent intent = new Intent(Register.this,Login.class);
                                startActivity(intent);
                            }
                            else {
                                Toast.makeText(Register.this, "Please try again!", Toast.LENGTH_SHORT).show();
                                progress_register.setVisibility(View.GONE);
                                Registerbtn.setEnabled(true);

                            }
                        }
                        else {
                            Toast.makeText(Register.this, "Please try again!", Toast.LENGTH_SHORT).show();
                            progress_register.setVisibility(View.GONE);
                            Registerbtn.setEnabled(true);
                        }

                    }

                    @Override
                    public void onFailure(Call<SignupResponseModel> call, Throwable t) {
                        Toast.makeText(Register.this, "Please try again!", Toast.LENGTH_SHORT).show();
                        progress_register.setVisibility(View.GONE);
                        Registerbtn.setEnabled(true);
                    }
                });


            }
        });
    }
}