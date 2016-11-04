package com.fineeat;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fineeat.Data.FERestaurantPromo;

import java.util.ArrayList;

//Created by Nicholascwz on 10/12/2016.


public class RecycleViewAdapterPromo extends RecyclerView.Adapter<RecycleViewAdapterPromo.ViewHolder>{
    private ArrayList<FERestaurantPromo> restaurants;
    private Context context;

    public RecycleViewAdapterPromo(Context con, ArrayList<FERestaurantPromo> rests){
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

            restaurantName = (TextView)view.findViewById(R.id.gridPromoName);
            restaurantLocation = (TextView)view.findViewById(R.id.gridPromoLocation);
            restaurantImage = (ImageView)view.findViewById(R.id.gridPromoImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridPromoCuisine);
            restaurantOccasion = (TextView)view.findViewById(R.id.gridPromoCategory);
            restaurantPromoMessage = (TextView)view.findViewById(R.id.gridPromoPromoMsg);
        }
    }

    @Override
    public RecycleViewAdapterPromo.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_promo, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FERestaurantPromo restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantImage.setImageResource(restaurant.getImagePromoLink());
        holder.restaurantLocation.setText(restaurant.getLocationName());
        holder.restaurantCuisine.setText(restaurant.getCuisine());
        holder.restaurantOccasion.setText(restaurant.getCategory());
        holder.restaurantPromoMessage.setText(restaurant.getPromoMessage());
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }


}
