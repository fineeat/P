package com.fineeat.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.fineeat.R;

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

        public ViewHolder(View view) {
            super(view);

            restaurantName = (TextView)view.findViewById(R.id.gridPromoName);
            restaurantLocation = (TextView)view.findViewById(R.id.gridPromoLocation);
            promoImage = (SimpleDraweeView)view.findViewById(R.id.gridPromoImage);
            restaurantCuisine = (TextView)view.findViewById(R.id.gridPromoCuisine);
            restaurantCategory = (TextView)view.findViewById(R.id.gridPromoCategory);
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
        FERestaurantPromo restaurantPromo = restaurantPromos.get(position);

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
    }

    @Override
    public int getItemCount() {
        return restaurantPromos.size();
    }


}
