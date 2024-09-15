package com.example.app1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.app1.Model.CategoryResponseModel;
import com.example.app1.adapter.Categories_product_Adapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {

    TextView register,username,password;
    Button loginbtn;
    ProgressBar progress_login;
    public int pk = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        SharedPreferences getSharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
        String user = getSharedPreferences.getString("User","none");
        if(user.equals("active")){
            Intent intent = new Intent(Login.this,Dashboard.class);
            startActivity(intent);
            finish();
        }


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getWindow().setStatusBarColor(Color.parseColor("#F0F2F5"));
        register = findViewById(R.id.register);
        username = findViewById(R.id.username);
        progress_login = findViewById(R.id.progress_login);
        password = findViewById(R.id.password);
        loginbtn = findViewById(R.id.loginbtn);
        progress_login.setVisibility(View.GONE);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });



    loginbtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//            Toast.makeText(Login.this, "username"+username.getText()+"password"+password.getText(), Toast.LENGTH_SHORT).show();
                progress_login.setVisibility(View.VISIBLE);
                loginbtn.setEnabled(false);
            ServiceApi serviceApi = ApiClient.getUser().create(ServiceApi.class);
            Call<List<UserResponseModel>> call = serviceApi.getUsers();

            call.enqueue(new Callback<List<UserResponseModel>>() {
                @Override
                public void onResponse(Call<List<UserResponseModel>> call, Response<List<UserResponseModel>> response) {
//                    Toast.makeText(Login.this, "Success User", Toast.LENGTH_SHORT).show();

                    if(response.body().size() > 0)
                    {
                        for(int i = 0; i<response.body().size(); i++)
                        {
                            if (username.getText().toString().equals(response.body().get(i).getUsername()) && password.getText().toString().equals(response.body().get(i).getPassword())) {
                                SharedPreferences sharedPreferences = getSharedPreferences("user",MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("Username",response.body().get(i).getUsername());
                                editor.apply();
                                Intent intent = new Intent(Login.this, Dashboard.class);
                                startActivity(intent);
                                finish();
                                SharedPreferences.Editor editor2 = sharedPreferences.edit();
                                editor2.putString("User","active");
                                editor2.apply();
                                pk=1;
                                progress_login.setVisibility(View.GONE);
                            }
                        }

                        if(pk == 0){
                            Toast.makeText(Login.this, "Wrong Username or Password", Toast.LENGTH_SHORT).show();
                            progress_login.setVisibility(View.GONE);
                            loginbtn.setEnabled(true);
                        }

                    }else {
                        Toast.makeText(Login.this, "There is no account here.", Toast.LENGTH_SHORT).show();
                        loginbtn.setEnabled(true);
                        progress_login.setVisibility(View.GONE);
                    }

                }

                @Override
                public void onFailure(Call<List<UserResponseModel>> call, Throwable t) {
                    Toast.makeText(Login.this, "not User", Toast.LENGTH_SHORT).show();
                    Log.e("TAG", "onFailure: "+t );
                    loginbtn.setEnabled(true);
                    progress_login.setVisibility(View.GONE);
                }
            });


        }
    });
    }
}