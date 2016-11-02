package com.fineeat;


 //Created by Nicholascwz on 10/12/2016.


public class FERestaurant {
    private int restaurantID;
    private String restaurantName;
    private int imageLink;
    private String locationName;
    private String locationGPS;
    private String cuisine;
    private String category;
    private String descriptionShort;
    private String descriptionLong;
    private int averagePriceRange;






    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String resname) {
        restaurantName = resname;
    }

    public int getImageLink() {
        return imageLink;
    }

    public void setImageLink(int imglink) {
        imageLink = imglink;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}