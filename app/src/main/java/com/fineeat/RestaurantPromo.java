package com.fineeat;


 //Created by Nicholascwz on 10/12/2016.


public class RestaurantPromo {
    private String restaurantName;
    private int imagePromoLink;
    private String locationName;
    private String cuisine;
    private String occasion;
    private String promoMessage;


    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String resname) {
        restaurantName = resname;
    }

    public int getImagePromoLink() {
        return imagePromoLink;
    }

    public void setImagePromoLink(int imglink) {
        imagePromoLink = imglink;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getOccasion() {
        return occasion;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }
}