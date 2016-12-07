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

import org.w3c.dom.Text;

import java.util.ArrayList;

import model.FERestaurant;
import util.FacebookFresco;
import util.Util;



//Created by Nicholascwz on 10/12/2016.


public class RecycleViewAdapterFavourite extends RecyclerView.Adapter<RecycleViewAdapterFavourite.ViewHolder>{
    private ArrayList<FERestaurant> restaurants;
    private Context context;

    public RecycleViewAdapterFavourite(Context con, ArrayList<FERestaurant> rests){
        restaurants = rests;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        SimpleDraweeView restaurantImage;
        TextView restaurantPrice;
        TextView restaurantCuisine;
        TextView restaurantCategory;
        TextView restaurantLocation;
        TextView restaurantDescription;
        TextView restaurantPhone;
        TextView restaurantWebsite;

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.gridRestaurantName);
            restaurantLocation = (TextView)view.findViewById(R.id.gridRestaurantLocation);
            restaurantImage = (SimpleDraweeView)view.findViewById(R.id.gridRestaurantImage);
            restaurantPrice = (TextView)view.findViewById(R.id.gridRestaurantAveragePrice);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridRestaurantCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridRestaurantCategory);
            restaurantDescription = (TextView)view.findViewById(R.id.gridRestaurantDescription);
            restaurantPhone = (TextView)view.findViewById(R.id.gridRestaurantPhone);
            restaurantWebsite = (TextView)view.findViewById(R.id.gridRestaurantWebsite);
        }
    }

    @Override
    public RecycleViewAdapterFavourite.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_restaurant, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        FERestaurant restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantCuisine.setText(restaurant.getCuisineString());
        holder.restaurantCategory.setText(restaurant.getCategoryString());
        holder.restaurantLocation.setText(restaurant.getLocationName());
        holder.restaurantDescription.setText(restaurant.getDescriptionLong());
        holder.restaurantPrice.setText(restaurant.getDollarSign());
        holder.restaurantPhone.setText(restaurant.getPhone());
        holder.restaurantWebsite.setText(restaurant.getWebsite());


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
