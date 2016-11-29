package com.fineeat.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fineeat.R;

import model.FERestaurant;
import util.FacebookFresco;
import util.Util;

import java.util.ArrayList;



//Created by Nicholascwz on 10/12/2016.


public class RecycleViewAdapterSearch extends RecyclerView.Adapter<RecycleViewAdapterSearch.ViewHolder>{
    private ArrayList<FERestaurant> restaurants;
    private Context context;

    public RecycleViewAdapterSearch(Context con, ArrayList<FERestaurant> rests){
        restaurants = rests;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        SimpleDraweeView restaurantImage;
        TextView restaurantCuisine;
        TextView restaurantCategory;
        TextView restaurantLocation;

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.gridSearchName);
            restaurantImage = (SimpleDraweeView)view.findViewById(R.id.gridSearchImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridSearchCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridSearchCategory);
            restaurantLocation = (TextView)view.findViewById(R.id.gridSearchLocation);
        }
    }

    @Override
    public RecycleViewAdapterSearch.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_search, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FERestaurant restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantCuisine.setText(restaurant.getCuisineString());
        holder.restaurantCategory.setText(restaurant.getCategoryString());
        holder.restaurantLocation.setText(restaurant.getLocationName());

        // Load images using Fresco image loader
        Uri uri = Uri.parse(Util.BaseURL + restaurant.getImagePath());
        // the basic way to load image //holder.restaurantImage.setImageURI(uri);
        FacebookFresco.frescoDisplayImage(context, holder.restaurantImage, uri);
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
