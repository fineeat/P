package model;


 //Created by Nicholascwz on 10/12/2016.


public class FERestaurant {
    private int restaurantID;
    private String restaurantName;
    private String imagePath;
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

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imglink) {
        imagePath = imglink;
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