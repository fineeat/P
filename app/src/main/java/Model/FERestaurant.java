package model;


 //Created by Nicholascwz on 10/12/2016.


import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FERestaurant {
    @SerializedName("restaurant_id")
    private int restaurantID;

    @SerializedName("restaurant_name")
    private String restaurantName;

    @SerializedName("restaurant_image_path")
    private String imagePath;

    @SerializedName("restaurant_location_name")
    private String locationName;

    @SerializedName("restaurant_location_long")
    private float locationlong;

    @SerializedName("restaurant_location_lat")
    private float locationlat;

    @SerializedName("restaurant_short_desc")
    private String descriptionShort;

    @SerializedName("restaurant_long_desc")
    private String descriptionLong;

    @SerializedName("restaurant_average_price")
    private int averagePriceRange;

    @SerializedName("cuisines")
    private ArrayList<FERestaurantCuisine> cuisines = new ArrayList<>();

    @SerializedName("categories")
    private ArrayList<FERestaurantCategory> categories = new ArrayList<>();

    @SerializedName("promos")
    private ArrayList<FERestaurantPromo> promos = new ArrayList<>();


    public int getRestaurantID() {
        return restaurantID;
    }

    public float getLocationlong() {
        return locationlong;
    }

    public float getLocationlat() {
        return locationlat;
    }

    public String getDescriptionShort() {
        return descriptionShort;
    }

    public String getDescriptionLong() {
        return descriptionLong;
    }

    public int getAveragePriceRange() {
        return averagePriceRange;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public String getLocationName() {
        return locationName;
    }

    public ArrayList<FERestaurantCuisine> getCuisines() {
        return cuisines;
    }

    public ArrayList<FERestaurantCategory> getCategories() {
        return categories;
    }

    public ArrayList<FERestaurantPromo> getPromos() {
        return promos;
    }

    public void update(FERestaurant res){
        restaurantName = res.getRestaurantName();
        imagePath = res.getImagePath();
        locationName = res.getLocationName();
        locationlong = res.getLocationlong();
        locationlat = res.getLocationlat();
        descriptionShort = res.getDescriptionShort();
        descriptionLong = res.getDescriptionLong();
        averagePriceRange = res.getAveragePriceRange();
        cuisines = res.getCuisines();
        categories = res.getCategories();
        promos = res.getPromos();
    }

    public void updateNMObjects()
    {
        for(FERestaurantCategory rescat:categories){
            rescat.updateRelation();
        }

        for(FERestaurantCuisine rescui:cuisines){
            rescui.updateRelation();
        }
    }

    public String getCategoryString()
    {
        ArrayList<String> strings = new ArrayList<>();

        for(FERestaurantCategory rescat:categories){
           strings.add(rescat.categoryName);
        }

        //Sort strings before displaying
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        return  TextUtils.join(", ", strings);
    }

    public String getCuisineString()
    {
        ArrayList<String> strings = new ArrayList<>();

        for(FERestaurantCuisine rescui:cuisines){
            strings.add(rescui.cuisineName);
        }

        //Sort strings before displaying
        Collections.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String str1, String str2) {
                return str1.compareTo(str2);
            }
        });

        return  TextUtils.join(", ", strings);
    }
}