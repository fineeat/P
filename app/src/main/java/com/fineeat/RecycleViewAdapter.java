package com.fineeat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Created by Nicholascwz on 10/12/2016.


public class RecycleViewAdapter  extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder>{
    private ArrayList<Restaurant> restaurants;
    private Context context;

    public RecycleViewAdapter(Context con, ArrayList<Restaurant> rests){
        restaurants = rests;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        ImageView restaurantImage;

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.gridText);
            restaurantImage = (ImageView)view.findViewById(R.id.gridImage);
        }
    }

    @Override
    public RecycleViewAdapter.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_single, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Restaurant restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantImage.setImageResource(restaurant.getImageLink());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


}
