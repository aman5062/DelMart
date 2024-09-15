package com.example.app1;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.app1.adapter.Categories_Adapter;
import com.example.app1.adapter.Special_Collection_Adapter;
import com.example.app1.adapter.Suggestion_Adapter;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    ImageView slide;
    RecyclerView recycle,recycle_box,special_collection_recycler,crishtmas_collection;
    Main_Adapter adapter;

    Special_Collection_Adapter s_collection;

    Suggestion_Adapter suggestion;
    Christmas_special_adapter christmas;
    ProgressBar progressBar;
    public ViewPager viewPager;
    public ImageAdapter imageAdapter;
    public Handler handler = new Handler();
    private int delay = 2000;
    private int page=0;

    public HomeFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @SuppressLint("MissingInflatedId")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        recycle = rootView.findViewById(R.id.recycle);
        recycle_box = rootView.findViewById(R.id.recycle_box);
        special_collection_recycler = rootView.findViewById(R.id.special_collection_recycler);
        viewPager = rootView.findViewById(R.id.viewPager);
        crishtmas_collection = rootView.findViewById(R.id.crishtmas_collection);
        imageAdapter = new ImageAdapter(getContext());
        viewPager.setAdapter(imageAdapter);
        progressBar = rootView.findViewById(R.id.progress_home);
        handler.postDelayed(runnable,delay);
        progressBar.setVisibility(View.VISIBLE);
        Callcategory();
        Suggestions();
        special_collections();
        Christmas_special();


        return rootView;
    }
    public void Suggestions(){
        ServiceApi serviceApi = ApiClient.getClient().create(ServiceApi.class);
        Call<ProductResponse_Model> call = serviceApi.getProductList();

        call.enqueue(new Callback<ProductResponse_Model>() {
            @Override
            public void onResponse(Call<ProductResponse_Model> call, Response<ProductResponse_Model> response) {
                if(response.body() != null)
                {
                    if(response.body().getProducts().size() > 0)
                    {
                        special_collection_recycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                        special_collection_recycler.setHasFixedSize(false);
                        suggestion = new Suggestion_Adapter(getContext(), response.body().getProducts());
                        special_collection_recycler.setAdapter(suggestion);


                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResponse_Model> call, Throwable t) {

            }
        });
    }
    public void Christmas_special(){
        ServiceApi serviceApi = ApiClient.getClient().create(ServiceApi.class);
        Call<ProductResponse_Model> call = serviceApi.getProductList();

        call.enqueue(new Callback<ProductResponse_Model>() {
            @Override
            public void onResponse(Call<ProductResponse_Model> call, Response<ProductResponse_Model> response) {
                if(response.body() != null)
                {
                    if(response.body().getProducts().size() > 0)
                    {
                        crishtmas_collection.setLayoutManager(new GridLayoutManager(getContext(), 3));
                        crishtmas_collection.setHasFixedSize(false);
                        christmas = new Christmas_special_adapter(getContext(), response.body().getProducts());
                        crishtmas_collection.setAdapter(christmas);


                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResponse_Model> call, Throwable t) {

            }
        });
    }
    public void special_collections(){

        ServiceApi serviceApi = ApiClient.getClient().create(ServiceApi.class);
        Call<ProductResponse_Model> call = serviceApi.getProductList();

        call.enqueue(new Callback<ProductResponse_Model>() {
            @Override
            public void onResponse(Call<ProductResponse_Model> call, Response<ProductResponse_Model> response) {
                if(response.body() != null)
                {
                    if(response.body().getProducts().size() > 0)
                    {
                        recycle_box.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
                        recycle_box.setHasFixedSize(false);
                        s_collection = new Special_Collection_Adapter(getContext(),response.body().getProducts());
                        recycle_box.setAdapter(s_collection);
                        progressBar.setVisibility(View.INVISIBLE);

                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResponse_Model> call, Throwable t) {

            }
        });
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
                        recycle.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
                        recycle.setHasFixedSize(false);
                        adapter = new Main_Adapter(getContext(),response.body().getCategories(),HomeFragment.this);
                        recycle.setAdapter(adapter);
                    }
                }
            }

            @Override
            public void onFailure(Call<ProductResponse_Model> call, Throwable t) {

            }
        });
    }

    public  void LoadFragemnt(String name)
    {

        ((Dashboard) getContext()).SetFragment("notification");


    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if (imageAdapter.getCount()==page){
                page=0;
            }else{
                page++;
            }
            viewPager.setCurrentItem(page,true);
            handler.postDelayed(this,delay);
        }
    };


}