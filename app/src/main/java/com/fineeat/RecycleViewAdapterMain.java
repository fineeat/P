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


public class RecycleViewAdapterMain extends RecyclerView.Adapter<RecycleViewAdapterMain.ViewHolder>{
    private ArrayList<RestaurantPromo> restaurants;
    private Context context;

    public RecycleViewAdapterMain(Context con, ArrayList<RestaurantPromo> rests){
        restaurants = rests;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        ImageView restaurantImage;
        TextView restaurantLocation;
        TextView restaurantCuisine;
        TextView restaurantOccasion;
        TextView restaurantPromoMessage;

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.grid1xName);
            restaurantLocation = (TextView)view.findViewById(R.id.grid1xLocation);
            restaurantImage = (ImageView)view.findViewById(R.id.grid1xImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.grid1xCuisine);
            restaurantOccasion = (TextView)view.findViewById(R.id.grid1xOccasion);
            restaurantPromoMessage = (TextView)view.findViewById(R.id.grid1xPromo);
        }
    }

    @Override
    public RecycleViewAdapterMain.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_1x, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RestaurantPromo restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantImage.setImageResource(restaurant.getImagePromoLink());
        holder.restaurantLocation.setText(restaurant.getLocationName());
        holder.restaurantCuisine.setText(restaurant.getCuisine());
        holder.restaurantOccasion.setText(restaurant.getOccasion());
        holder.restaurantPromoMessage.setText(restaurant.getPromoMessage());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


}
