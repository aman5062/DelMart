package com.example.app1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.app1.CategoryFragment;
import com.example.app1.Main_Adapter;
import com.example.app1.ProductResponse_Model;
import com.example.app1.R;

import java.util.List;

public class Category_Adapter extends RecyclerView.Adapter<Category_Adapter.ViewHolder>{
    Context context;
    CategoryFragment fragment;
    List<ProductResponse_Model.Categories> sList;
    public Category_Adapter(Context context, List<ProductResponse_Model.Categories> slist, CategoryFragment fragment){
        this.context = context;
        this.sList = slist;
        this.fragment = fragment;
    }

    @NonNull
    @Override
    public Category_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category,parent,false);
        Category_Adapter.ViewHolder viewHolder = new Category_Adapter.ViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull Category_Adapter.ViewHolder holder, int position) {
        Glide.with(context)
                .load(sList.get(holder.getAdapterPosition()).getImg())
                .centerCrop()
                .into(holder.image_view);
        holder.title.setText(sList.get(holder.getAdapterPosition()).getTitle());

        holder.image_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                YoYo.with(Techniques.FadeIn)
                        .duration(700)
                        .repeat(0)
                        .playOn(holder.image_view);
                fragment.CallCategory(sList.get(holder.getAdapterPosition()).getTitle());
                fragment.progress_category.setVisibility(View.VISIBLE);
//                Toast.makeText(context, sList.get(holder.getAdapterPosition()).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        holder.btn_card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



            }
        });
    }

    @Override
    public int getItemCount() {
        return sList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image_view;
        TextView title;
        LinearLayout btn_card;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            image_view = itemView.findViewById(R.id.image_view);
            title = itemView.findViewById(R.id.title);
            btn_card = itemView.findViewById(R.id.btn_card);
        }

    }
}
