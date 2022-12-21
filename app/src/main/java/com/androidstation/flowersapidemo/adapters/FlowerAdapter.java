package com.androidstation.flowersapidemo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.androidstation.flowersapidemo.R;
import com.androidstation.flowersapidemo.pojo.Flower;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FlowerAdapter extends RecyclerView.Adapter<FlowerAdapter.Holder> {

    private ArrayList<Flower> flowers ; //= new ArrayList<>();
    private Context context ;

    //done
    public FlowerAdapter(Context context , ArrayList<Flower> flowers) {
        this.context = context;
        this.flowers = flowers;
    }


    //done
    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Holder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_flower,
                        parent,
                        false));
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        Flower flower = flowers.get(position); /* views that I want to display it */

        holder.tv_flower.setText(flower.getName());
        holder.tv_category.setText(String.format("Category :%s" , flower.getCategory()));
        holder.tv_price.setText(String.format("Price :%s", flower.getPrice()));

        Glide
                .with(context)
                .load("https://services.hanselandpetal.com/photos/" +flower.getPhoto())
                .into(holder.iv_flower);
    }

    @Override
    public int getItemCount() {
        if (this.flowers != null){
            return this.flowers.size();
        } else {
            return 0;
        }
    }

    public void setList(ArrayList<Flower> flowersList) {
        this.flowers = flowersList;
        notifyDataSetChanged();
    }

    //done
    class Holder extends RecyclerView.ViewHolder {
        TextView tv_flower;
        TextView tv_price;
        TextView tv_category;
        ImageView iv_flower;
        //done
        Holder(@NonNull View itemView) {
            super(itemView);
            iv_flower = itemView.findViewById(R.id.iv_flower);
            tv_flower = itemView.findViewById(R.id.tv_flower);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_category = itemView.findViewById(R.id.tv_category);
        }
    }
}
