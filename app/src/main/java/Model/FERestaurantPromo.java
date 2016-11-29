package model;


 //Created by Nicholascwz on 10/12/2016.


import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class FERestaurantPromo {
    @SerializedName("promo_id")
    private int restaurantPromoID;

    @SerializedName("restaurant_id")
    private int restaurantID;

    @SerializedName("promo_image_path")
    private String imagePromoPath;

    @SerializedName("promo_message")
    private String promoMessage;

    @SerializedName("promo_validity_start")
    private Date validityStart;

    @SerializedName("promo_validity_end")
    private Date validityEnd;

    @SerializedName("promo_is_expired")
    private Boolean isExpired;

    @SerializedName("promo_display_start")
    private Date displayStart;

    @SerializedName("promo_display_end")
    private Date displayEnd;

    @SerializedName("promo_sortnum")
    private int promoSortNum;

    private FERestaurant restaurant;
    private String restaurantName;
    private String restaurantCategory;
    private String restaurantCuisine;
    private String restaurantLocation;

    public int getRestaurantPromoID() {
        return restaurantPromoID;
    }

    public int getRestaurantID() {
        return restaurantID;
    }

    public Date getValidityStart() {
        return validityStart;
    }

    public Date getValidityEnd() {
        return validityEnd;
    }

    public Boolean getIsExpired() {
        return isExpired;
    }

    public Date getDisplayStart() {
        return displayStart;
    }

    public Date getDisplayEnd() {
        return displayEnd;
    }

    public int getPromoSortNum() {
        return promoSortNum;
    }

    public FERestaurant getRestaurant() {
        return restaurant;
    }

    public String getImagePromoPath() {
        return imagePromoPath;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public Boolean getExpired() {
        return isExpired;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public String getRestaurantCuisine() {
        return restaurantCuisine;
    }

    public String getRestaurantLocation() {
        return restaurantLocation;
    }

    public void update(FERestaurantPromo promo){
        restaurantID = promo.getRestaurantID();
        imagePromoPath = promo.getImagePromoPath();
        promoMessage = promo.getPromoMessage();
        validityStart = promo.getValidityStart();
        validityEnd = promo.getValidityEnd();
        isExpired = promo.getIsExpired();
        displayStart = promo.getDisplayStart();
        displayEnd = promo.getDisplayEnd();
        promoSortNum = promo.getPromoSortNum();
    }

    public void updateRestaurantLink(){
        restaurant = Company.restaurantsHM.get(restaurantID);

        if( restaurant != null){
            restaurantName = restaurant.getRestaurantName();
            restaurantCategory = restaurant.getCategoryString();
            restaurantCuisine = restaurant.getCuisineString();
            restaurantLocation = restaurant.getLocationName();
        }
    }


}