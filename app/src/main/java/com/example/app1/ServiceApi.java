package com.example.app1;

import com.example.app1.Model.CategoryResponseModel;
import com.example.app1.Model.SignupResponseModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ServiceApi {
    @GET("product.json")
    Call<ProductResponse_Model> getProductList();

    @GET("smartphones")
    Call<CategoryResponseModel> getSmartPhone();
    @GET("Laptops")
    Call<CategoryResponseModel> getLaptops();
    @GET("Home-Decoration")
    Call<CategoryResponseModel> getHome();
    @GET("Groceries")
    Call<CategoryResponseModel> getGroceries();
    @GET("automotive")
    Call<CategoryResponseModel> getAutomotive();
    @GET("womens-dresses")
    Call<CategoryResponseModel> getFashion();

    @GET("55n540vlv2bxp")
    Call<List<UserResponseModel>> getUsers();

    @FormUrlEncoded
    @POST("55n540vlv2bxp")
    Call<SignupResponseModel> getSignup(@Field("Username") String username, @Field("Password") String password);

}




