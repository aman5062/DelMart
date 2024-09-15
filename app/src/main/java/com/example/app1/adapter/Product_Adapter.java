package com.example.app1.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app1.Product_Details;
import com.example.app1.R;

import java.util.ArrayList;

public class Product_Adapter extends RecyclerView.Adapter<Product_Adapter.ViewHolder>{
    ArrayList<String> name;
    ArrayList<Integer> image;
    ArrayList<String> price;
    Context context;

    public Product_Adapter(Context baseContext, ArrayList<String> Name, ArrayList<Integer> Image, ArrayList<String> Price) {
        this.context = baseContext;
        this.name = Name;
        this.image = Image;
        this.price = Price;
    }

    @NonNull
    @Override
    public Product_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_view,parent,false);
        return new Product_Adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Product_Adapter.ViewHolder holder, int position) {
        holder.Name.setText(name.get(holder.getAdapterPosition()));
        holder.price.setText("₹"+price.get(holder.getAdapterPosition()));
        Glide.with(context)
                .load(image.get(holder.getAdapterPosition()))
                .centerCrop()
                .into(holder.product_image);
        holder.box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(),Product_Details.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("Product_name",name.get(holder.getAdapterPosition()));
                intent.putExtra("Product_price",price.get(holder.getAdapterPosition()));
                intent.putExtra("Product_image",String.valueOf(image.get(holder.getAdapterPosition())));
                Log.e("TAG", "Image: "+image.get(holder.getAdapterPosition()));
                intent.putExtra("context", String.valueOf(context));
                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView product_image;
        TextView Name,price;
        LinearLayout box;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            product_image = itemView.findViewById(R.id.product_image);
            Name = itemView.findViewById(R.id.name);
            price = itemView.findViewById(R.id.price);
            box = itemView.findViewById(R.id.box);

        }
    }
}
