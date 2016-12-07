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
import model.FERestaurantPromo;
import util.FacebookFresco;
import util.Util;

import java.util.ArrayList;


//Created by Nicholascwz on 10/12/2016.

public class RecycleViewAdapterPromo extends RecyclerView.Adapter<RecycleViewAdapterPromo.ViewHolder>{
    private ArrayList<FERestaurantPromo> restaurantPromos;
    private Context context;

    public RecycleViewAdapterPromo(Context con, ArrayList<FERestaurantPromo> promos){
        restaurantPromos = promos;
        context = con;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView restaurantName;
        SimpleDraweeView promoImage;
        TextView restaurantLocation;
        TextView restaurantCuisine;
        TextView restaurantCategory;
        TextView restaurantPromoMessage;
        ToggleButton favouriteToggleButton;
        Button shareButton;
        CardView cardView;


        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view.findViewById(R.id.gridPromoCardView);
            restaurantName = (TextView)view.findViewById(R.id.gridPromoName);
            restaurantLocation = (TextView)view.findViewById(R.id.gridPromoLocation);
            promoImage = (SimpleDraweeView)view.findViewById(R.id.gridPromoImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridPromoCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridPromoCategory);
            restaurantPromoMessage = (TextView)view.findViewById(R.id.gridPromoPromoMsg);
            favouriteToggleButton = (ToggleButton)view.findViewById(R.id.gridPromoToggleButtonFav);
            shareButton = (Button)view.findViewById(R.id.gridPromoButtonShare);
        }
    }

    @Override
    public RecycleViewAdapterPromo.ViewHolder onCreateViewHolder(ViewGroup viewgroup, int i) {
        View view = LayoutInflater.from(viewgroup.getContext()).inflate(R.layout.grid_promo, viewgroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final FERestaurantPromo restaurantPromo = restaurantPromos.get(position);

        //Update Restaurant Link required to get the information below. Safety measure in case the link is not set properly upon import.
        restaurantPromo.updateRestaurantLink();

        holder.restaurantName.setText(restaurantPromo.getRestaurantName());
        holder.restaurantLocation.setText(restaurantPromo.getRestaurantLocation());
        holder.restaurantCuisine.setText(restaurantPromo.getRestaurantCuisine());
        holder.restaurantCategory.setText(restaurantPromo.getRestaurantCategory());
        holder.restaurantPromoMessage.setText(restaurantPromo.getPromoMessage());

        // Load images using Fresco image loader
        Uri uri = Uri.parse(Util.BaseURL + restaurantPromo.getImagePromoPath());
        // the basic way to load image //holder.restaurantImage.setImageURI(uri);
        FacebookFresco.frescoDisplayImage(context, holder.promoImage, uri);

        //setOnClickListener for buttons
        holder.favouriteToggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean ischecked) {
                Toast toast;
                FERestaurant restaurant = restaurantPromo.getRestaurant();

                if(ischecked){
                    Company.loggedUser.addFavourite(restaurant);
                    toast = Toast.makeText(context, "Added to Favourite", Toast.LENGTH_SHORT);
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
                Toast toast = Toast.makeText(context, restaurantPromo.getRestaurantName() + " clicked", Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurantPromos.size();
    }


}
