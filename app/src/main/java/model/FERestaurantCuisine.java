package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicholascwz on 11/29/2016.
 */

public class FERestaurantCuisine {
    @SerializedName("restaurant_id")
    private int restaurantID;

    @SerializedName("cuisine_id")
    private int cuisineID;

    FERestaurant restaurant;
    FECuisine cuisine;
    String restaurantName;
    String cuisineName;

    public void updateRelation()
    {
        restaurant = Company.restaurantsHM.get(restaurantID);

        if(restaurant != null){
            restaurantName = restaurant.getRestaurantName();
        }

        cuisine = Company.cuisinesHM.get(cuisineID);

        if(cuisine != null){
            cuisineName = cuisine.getName();
        }
    }
}
