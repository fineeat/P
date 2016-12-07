package model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Nicholascwz on 11/2/2016.
 */

public class FEUser {
    public FEUser(int id, String name, String email, String phone){
        userID = id;
        this.name = name;
        this.email = email;
        phoneNumber = phone;
    }

    private int userID;
    private String name;
    private String email;
    private String phoneNumber;

    private ArrayList<FEFavourite> favourites = new ArrayList<>();
    private HashMap<Integer, FEFavourite> favouritesHM = new HashMap<>();

    public int getUserID() {
        return userID;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public ArrayList<FEFavourite> getFavourites() {
        return favourites;
    }

    public ArrayList<FERestaurant> getFavouriteRestaurants(){
        ArrayList<FERestaurant> restaurants = new ArrayList<>();

        for(FEFavourite fav:favourites){
            FERestaurant res = fav.getRestaurant();

            if(res != null){
                restaurants.add(res);
            }
        }

        return restaurants;
    }

    public FEFavourite addFavourite(FERestaurant restaurant){
        int restaurantID = restaurant.getRestaurantID();
        FEFavourite fav = favouritesHM.get(restaurantID);

        //Create favourite
        if(fav == null){
            fav = new FEFavourite(this, restaurant);
            favourites.add(fav);
            favouritesHM.put(restaurantID, fav);
        }

        return fav;
    }

    public void removeFavourite(FERestaurant restaurant) {
        int restaurantID = restaurant.getRestaurantID();

        //Remove favourite
        FEFavourite fav = favouritesHM.get(restaurantID);
    }
}
