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


public class RecycleViewAdapterRestaurant extends RecyclerView.Adapter<RecycleViewAdapterRestaurant.ViewHolder>{
    private ArrayList<FERestaurant> restaurants;
    private Context context;

    public RecycleViewAdapterRestaurant(Context con, ArrayList<FERestaurant> rests){
        restaurants = rests;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        ImageView restaurantImage;
        TextView restaurantCuisine;
        TextView restaurantCategory;

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.gridSearchName);
            restaurantImage = (ImageView)view.findViewById(R.id.gridSearchImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridSearchCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridSearchCategory);
        }
    }

    @Override
    public RecycleViewAdapterRestaurant.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_search, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FERestaurant restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantImage.setImageResource(restaurant.getImageLink());
        holder.restaurantCuisine.setText(restaurant.getCuisine());
        holder.restaurantCategory.setText(restaurant.getCategory());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


}
