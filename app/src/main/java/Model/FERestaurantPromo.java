package model;


 //Created by Nicholascwz on 10/12/2016.


import java.util.Date;

public class FERestaurantPromo {
    private int restaurantPromoID;
    private int resutaurantID;
    private String restaurantName;
    private String imagePromoPath;
    private String locationName;
    private String locationGPS;
    private String cuisine;
    private String category;
    private String promoMessage;
    private Date validityStart;
    private Date validityEnd;



    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String resname) {
        restaurantName = resname;
    }

    public String getImagePromoPath() {
        return imagePromoPath;
    }

    public void setImagePromoPath(String imgpath) {
        imagePromoPath = imgpath;
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

    public String getPromoMessage() {
        return promoMessage;
    }

    public void setPromoMessage(String promoMessage) {
        this.promoMessage = promoMessage;
    }
}