package com.fineeat;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.fineeat.Data.FERestaurant;

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
        holder.restaurantCuisine.setText(restaurant.getCuisine());
        holder.restaurantCategory.setText(restaurant.getCategory());
        holder.restaurantLocation.setText(restaurant.getLocationName());

        // Load images using Fresco image loader
        Uri uri = Uri.parse(restaurant.getImagePath());
        // the basic way to load image //holder.restaurantImage.setImageURI(uri);
        frescoControllerListener(holder.restaurantImage, uri);

    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public float getScreenWidth(){
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return displayMetrics.widthPixels; // for dp divide by displayMetrics.density;
    }

    public void frescoControllerListener(final SimpleDraweeView simpledraweeview, Uri uri){
        ControllerListener controllerListener = new BaseControllerListener<ImageInfo>() {
            @Override
            public void onFinalImageSet(
                    String id,
                    @Nullable ImageInfo imageInfo,
                    @Nullable Animatable anim) {
                if (imageInfo == null) {
                    return;
                }

                //Image resoultion
                int imageWidth = imageInfo.getWidth();
                int imageHeight = imageInfo.getHeight();
                //draweeviewwidth
                int draweeViewWidth = (int)getScreenWidth();
                //Only set if image width is greater than zero
                if( imageWidth > 0 && imageHeight > 0 && draweeViewWidth > 0 )
                {
                    simpledraweeview.getLayoutParams().height = draweeViewWidth * imageHeight / imageWidth;
                    simpledraweeview.requestLayout();
                }


            }

            @Override
            public void onFailure(String id, Throwable throwable) {
                Log.e(getClass().toString(), throwable + " || Error loading " + id);
            }
        };

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setControllerListener(controllerListener)
                .setUri(uri)
                // other setters
                .build();
        simpledraweeview.setController(controller);
    }
}
