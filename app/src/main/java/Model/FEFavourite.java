package model;

/**
 * Created by Nicholascwz on 11/2/2016.
 */

public class FEFavourite {
    public FEFavourite(FEUser user, FERestaurant res){
        this.user = user;
        restaurant = res;

        if(res != null) {
            restaurantID = res.getRestaurantID();
        }

        if(user != null) {
            userid = user.getUserID();
        }
    }

    private int restaurantID;
    private int userid;

    private FERestaurant restaurant;
    private FEUser user;

    public int getRestaurantID() {
        return restaurantID;
    }

    public int getUserid() {
        return userid;
    }

    public FERestaurant getRestaurant() {
        return restaurant;
    }

    public FEUser getUser() {
        return user;
    }
}
