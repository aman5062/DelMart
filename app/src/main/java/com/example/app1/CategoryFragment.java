package com.example.app1;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Switch;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app1.Model.CategoryResponseModel;
import com.example.app1.adapter.Categories_product_Adapter;
import com.example.app1.adapter.Category_Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    public RecyclerView frame1;
    public static RecyclerView frame2;
    Category_Adapter category;
    public static ProgressBar progress_category;

    public static Categories_product_Adapter products;
    String name;
    public CategoryFragment() {

    }

    public static CategoryFragment newInstance() {
        return new CategoryFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);
        progress_category = rootView.findViewById(R.id.progress_category);
         frame1 = rootView.findViewById(R.id.frame1);
         frame2 = rootView.findViewById(R.id.frame2);
        progress_category.setVisibility(View.VISIBLE);

       Callcategory();
        CallCategory("Smartphones");

        return rootView;
    }
    public void Callcategory(){
        ServiceApi serviceApi = ApiClient.getClient().create(ServiceApi.class);
        Call<ProductResponse_Model> call = serviceApi.getProductList();

        call.enqueue(new Callback<ProductResponse_Model>() {
            @Override
            public void onResponse(Call<ProductResponse_Model> call, Response<ProductResponse_Model> response) {
                if(response.body() != null)
                {
                    if(response.body().getProducts().size() > 0)
                    {
                        frame1.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));
                        frame1.setHasFixedSize(false);
                        category = new Category_Adapter(getContext(),response.body().getCategories(), CategoryFragment.this);
                        frame1.setAdapter(category);
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResponse_Model> call, Throwable t) {

            }
        });}
//
//    public void CallProducts(String s)
//    {
//        if(s.equals("Grocery")){
//        ArrayList<String> Name = new ArrayList<String>();
//        Name.add("Refine Oil");
//        Name.add("Snacks");
//        Name.add("Tea");
//        Name.add("Rice");
//        Name.add("Vegetables");
//        Name.add("Pulses");
//
//
//        ArrayList<Integer> Image = new ArrayList<Integer>();
//        Image.add(R.drawable.oil);
//        Image.add(R.drawable.snakes);
//        Image.add(R.drawable.tea);
//        Image.add(R.drawable.rice);
//        Image.add(R.drawable.vegitables);
//        Image.add(R.drawable.pulses);
//
//
//
//        frame2.setLayoutManager(new GridLayoutManager(getActivity(),2));
//        frame2.setHasFixedSize(true);
//        products = new Categories_product_Adapter(getContext(),Name,Image);
//        frame2.setAdapter(products);
//        }
//        else if (s.equals("Electronics")) {
//            ArrayList<String> Name = new ArrayList<String>();
//            Name.add("Washing Machine");
//            Name.add("Mobile");
//            Name.add("Television");
//            Name.add("Watches");
//            Name.add("Games");
//            Name.add("Headphones");
//
//
//            ArrayList<Integer> Image = new ArrayList<Integer>();
//            Image.add(R.drawable.washing_machine);
//            Image.add(R.drawable.mobile);
//            Image.add(R.drawable.television);
//            Image.add(R.drawable.watch);
//            Image.add(R.drawable.games);
//            Image.add(R.drawable.headphones);
//
//
//
//            frame2.setLayoutManager(new GridLayoutManager(getActivity(),2));
//            frame2.setHasFixedSize(true);
//            products = new Categories_product_Adapter(getContext(),Name,Image);
//
//            frame2.setAdapter(products);
//        }
//    }

    public static void CallCategory(String s)
    {

        if (s.equals("Smartphones")) {

            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getSmartPhone();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }
        else if (s.equals("Laptops")) {
            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getLaptops();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }
        else if (s.equals("Home")) {
            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getHome();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }
        else if (s.equals("Groceries")) {
            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getGroceries();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }
        else if (s.equals("Fashion")) {
            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getFashion();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }
        else if (s.equals("Accesories")) {
            ServiceApi serviceApi = ApiClient.getClientCategory().create(ServiceApi.class);
            Call<CategoryResponseModel> call = serviceApi.getAutomotive();

            call.enqueue(new Callback<CategoryResponseModel>() {
                @Override
                public void onResponse(Call<CategoryResponseModel> call, Response<CategoryResponseModel> response) {


                    if (response.body() != null) {
                        if (response.body().getTotal() > 0) {
                            frame2.setLayoutManager(new GridLayoutManager(frame2.getContext(), 2, RecyclerView.VERTICAL, false));
                            frame2.setHasFixedSize(false);
                            products = new Categories_product_Adapter(frame2.getContext(), response.body().getProducts());
                            frame2.setAdapter(products);
                            progress_category.setVisibility(View.INVISIBLE);
                        }
                    }

                }

                @Override
                public void onFailure(Call<CategoryResponseModel> call, Throwable t) {

                }
            });
        }

    }
}