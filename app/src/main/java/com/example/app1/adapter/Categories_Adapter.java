package com.example.app1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.app1.R;

import java.util.ArrayList;

public class Categories_Adapter extends RecyclerView.Adapter<Categories_Adapter.ViewHolder> {

//    String Image_link;
    ArrayList<String> Name;
    ArrayList<Integer> Image;
    Context context;
    public Categories_Adapter(Context context, ArrayList<String> Name, ArrayList<Integer> Image) {
        this.Name = Name;
        this.context = context;
        this.Image = Image;
    }

    public Categories_Adapter() {
    }

    @NonNull
    @Override
    public Categories_Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.category,parent,false);
        Categories_Adapter.ViewHolder viewHolder = new Categories_Adapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.Title.setText(Name.get(position).toString());
        Glide.with(context)
                .load(Image.get(position))
                .centerCrop()
                .into(holder.image_view);

       holder.image_view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               YoYo.with(Techniques.FadeIn)
                       .duration(700)
                       .repeat(0)
                       .playOn(holder.image_view);
           }
       });
       holder.image_view.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

           }
       });

      /*  holder.image_view.setBackgroundResource(Image.get(holder.getAdapterPosition()));*/

//        Toast.makeText(context, ""+Image.get(position), Toast.LENGTH_SHORT).show();

    }

    @Override
    public int getItemCount() {
        return Name.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView image_view;
        TextView Title;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            image_view = itemView.findViewById(R.id.image_view);
            Title = itemView.findViewById(R.id.title);
        }
    }
}

