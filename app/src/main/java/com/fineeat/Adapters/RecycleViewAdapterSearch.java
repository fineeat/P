package com.fineeat.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fineeat.R;

import model.Company;
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
        TextView restaurantDescription;
        ToggleButton favouriteToggleButton;
        Button shareButton;
        CardView cardView;


        public ViewHolder(View view) {
            super(view);
            cardView = (CardView) view.findViewById(R.id.gridSearchCardView);
            restaurantName = (TextView)view.findViewById(R.id.gridSearchName);
            restaurantImage = (SimpleDraweeView)view.findViewById(R.id.gridSearchImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridSearchCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridSearchCategory);
            restaurantLocation = (TextView)view.findViewById(R.id.gridSearchLocation);
            favouriteToggleButton = (ToggleButton)view.findViewById(R.id.gridSearchToggleButtonFav);
            shareButton = (Button)view.findViewById(R.id.gridSearchButtonShare);
        }
    }

    @Override
    public RecycleViewAdapterSearch.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_search, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FERestaurant restaurant = restaurants.get(position);

        holder.restaurantName.setText(restaurant.getRestaurantName());
        holder.restaurantCuisine.setText(restaurant.getCuisineString());
        holder.restaurantCategory.setText(restaurant.getCategoryString());
        holder.restaurantLocation.setText(restaurant.getLocationName());

        // Load images using Fresco image loader
        Uri uri = Uri.parse(Util.BaseURL + restaurant.getImagePath());
        // the basic way to load image //holder.restaurantImage.setImageURI(uri);
        FacebookFresco.frescoDisplayImage(context, holder.restaurantImage, uri);

        //setOnClickListener for buttons
        holder.favouriteToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                Toast toast;

                if(ischecked){
                    Company.loggedUser.addFavourite(restaurant);
                    toast = Toast.makeText(context, "Added to Favourite "+ restaurant.getRestaurantName(), Toast.LENGTH_SHORT);
                }else{
                    Company.loggedUser.removeFavourite(restaurant);
                    toast = Toast.makeText(context, "Removed from Favourite", Toast.LENGTH_SHORT);
                }

                toast.show();
            }
        });

        holder.shareButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, "Share button clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast toast = Toast.makeText(context, restaurant.getRestaurantName() + " clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }
}
