package model;

import java.util.ArrayList;

/**
 * Created by Nicholascwz on 11/15/2016.
 */

public class Company {
    public static ArrayList<FECategory> categories = new ArrayList<>();
    public static ArrayList<FECuisine> cuisines = new ArrayList<>();
    public static ArrayList<FEUser> users = new ArrayList<>();
    public static ArrayList<FERestaurant> restaurants = new ArrayList<>();
    public static ArrayList<FELocation> locations = new ArrayList<>();

    public static FECategory createCategory(int id, String name, int sort){
        FECategory category = new FECategory(id, name, sort);
        categories.add(category);

        return category;
    }
}
