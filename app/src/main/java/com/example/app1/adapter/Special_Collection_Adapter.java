package com.example.app1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app1.Main_Adapter;
import com.example.app1.ProductResponse_Model;
import com.example.app1.Product_Details;
import com.example.app1.R;

import java.util.List;

public class Special_Collection_Adapter extends RecyclerView.Adapter<Special_Collection_Adapter.ViewHolder> {
    Context context;
    List<ProductResponse_Model.Product> sList;

    public Special_Collection_Adapter(Context context, List<ProductResponse_Model.Product> slist){
        this.context = context;
        this.sList = slist;
    }


    @NonNull
    @Override
    public Special_Collection_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.box,parent,false);
        Special_Collection_Adapter.ViewHolder viewHolder = new Special_Collection_Adapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Special_Collection_Adapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(sList.get(holder.getAdapterPosition()).getThumbnail())
                .centerCrop()
                .into(holder.product_image);
        holder.product_name.setText(sList.get(holder.getAdapterPosition()).getTitle());
        holder.product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Product_Details.class);
                intent.putExtra("Product_image",sList.get(holder.getAdapterPosition()).getThumbnail());
                intent.putExtra("Product_name",sList.get(holder.getAdapterPosition()).getTitle());
                intent.putExtra("price",String.valueOf(sList.get(holder.getAdapterPosition()).getPrice()));
                intent.putExtra("discription",sList.get(holder.getAdapterPosition()).getDescription());
                intent.putExtra("rating",String.valueOf(sList.get(holder.getAdapterPosition()).getPrice()));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView product_price,product_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            product_price = itemView.findViewById(R.id.product_price);
            product_name = itemView.findViewById(R.id.product_name);


        }
    }
}
