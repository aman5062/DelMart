package com.example.app1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Main_Adapter extends RecyclerView.Adapter<Main_Adapter.ViewHolder> {
    Context context;
    List<ProductResponse_Model.Categories> cList;

   HomeFragment fragment;
    public Main_Adapter(Context context, List<ProductResponse_Model.Categories> products,  HomeFragment fragment) {
        this.context = context;
        this.cList = products;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public Main_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category,parent,false);
        Main_Adapter.ViewHolder viewHolder = new Main_Adapter.ViewHolder(view);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull Main_Adapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(cList.get(holder.getAdapterPosition()).getImg())
                .centerCrop()
                .into(holder.image_view);
        holder.title.setText(cList.get(holder.getAdapterPosition()).getTitle());
        holder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CategoryFragment.CallCategory(cList.get(holder.getAdapterPosition()).getTitle());

                fragment.LoadFragemnt("notification");

            }
        });
    }


    @Override
    public int getItemCount() {
        return cList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
        }

    }
}
