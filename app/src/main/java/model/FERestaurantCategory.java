package model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Nicholascwz on 11/29/2016.
 */

public class FERestaurantCategory {
    @SerializedName("restaurant_id")
    private int restaurantID;

    @SerializedName("category_id")
    private int categoryID;

    FERestaurant restaurant;
    FECategory category;
    String restaurantName;
    String categoryName;

    public void updateRelation()
    {
        restaurant = Company.restaurantsHM.get(restaurantID);

        if(restaurant != null){
            restaurantName = restaurant.getRestaurantName();
        }

        category = Company.categoriesHM.get(categoryID);

        if(category != null){
            categoryName = category.getName();
        }
    }
}
